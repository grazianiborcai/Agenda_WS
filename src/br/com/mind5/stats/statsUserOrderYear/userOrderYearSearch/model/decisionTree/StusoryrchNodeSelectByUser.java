package br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.action.StusoryrchVisiMergeStusorygerch;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.action.StusoryrchVisiMergeStusorygrarch;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.action.StusoryrchVisiMergeStusorylirch;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.checker.StusoryrchCheckStusorygrarch;


public final class StusoryrchNodeSelectByUser extends DeciTreeTemplateWrite<StusoryrchInfo> {
	
	public StusoryrchNodeSelectByUser(DeciTreeOption<StusoryrchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusoryrchInfo> buildCheckerHook(DeciTreeOption<StusoryrchInfo> option) {
		List<ModelChecker<StusoryrchInfo>> queue = new ArrayList<>();		
		ModelChecker<StusoryrchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StusoryrchCheckStusorygrarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusoryrchInfo>> buildActionsOnPassedHook(DeciTreeOption<StusoryrchInfo> option) {
		List<ActionStd<StusoryrchInfo>> actions = new ArrayList<>();

		ActionStd<StusoryrchInfo> mergeAggregated = new ActionStdCommom<StusoryrchInfo>(option, StusoryrchVisiMergeStusorygrarch.class);
		ActionLazy<StusoryrchInfo> mergeStaging = new ActionLazyCommom<StusoryrchInfo>(option, StusoryrchVisiMergeStusorygerch.class);
		
		mergeAggregated.addPostAction(mergeStaging);
		
		actions.add(mergeAggregated);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StusoryrchInfo>> buildActionsOnFailedHook(DeciTreeOption<StusoryrchInfo> option) {
		List<ActionStd<StusoryrchInfo>> actions = new ArrayList<>();

		ActionStd<StusoryrchInfo> mergeLive = new ActionStdCommom<StusoryrchInfo>(option, StusoryrchVisiMergeStusorylirch.class);
		
		actions.add(mergeLive);
		return actions;
	}
}
