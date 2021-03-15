package br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.action.LazyStusoryrchMergeStusorygerch;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.action.StdStusoryrchMergeStusorygrarch;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.action.StdStusoryrchMergeStusorylirch;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.checker.StusoryrchCheckStusorygrarch;


public final class NodeStusoryrchSelectByUser extends DeciTreeTemplateWrite<StusoryrchInfo> {
	
	public NodeStusoryrchSelectByUser(DeciTreeOption<StusoryrchInfo> option) {
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

		ActionStd<StusoryrchInfo> mergeAggregated = new StdStusoryrchMergeStusorygrarch(option);
		ActionLazy<StusoryrchInfo> mergeStaging = new LazyStusoryrchMergeStusorygerch(option.conn, option.schemaName);
		
		mergeAggregated.addPostAction(mergeStaging);
		
		actions.add(mergeAggregated);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StusoryrchInfo>> buildActionsOnFailedHook(DeciTreeOption<StusoryrchInfo> option) {
		List<ActionStd<StusoryrchInfo>> actions = new ArrayList<>();

		ActionStd<StusoryrchInfo> mergeLive = new StdStusoryrchMergeStusorylirch(option);
		
		actions.add(mergeLive);
		return actions;
	}
}
