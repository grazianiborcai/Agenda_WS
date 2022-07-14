package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.decisionTree;

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
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info.StusorygeInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.action.StusorygeVisiRootUpsert;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.action.StusorygeVisiMergeOrdist;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.checker.StusorygeCheckOrdist;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.checker.StusorygeCheckWriteOrdist;


public final class StusorygeRootUpsertOrderem extends DeciTreeTemplateWrite<StusorygeInfo> {
	
	public StusorygeRootUpsertOrderem(DeciTreeOption<StusorygeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusorygeInfo> buildCheckerHook(DeciTreeOption<StusorygeInfo> option) {
		List<ModelChecker<StusorygeInfo>> queue = new ArrayList<>();		
		ModelChecker<StusorygeInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StusorygeCheckWriteOrdist(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StusorygeCheckOrdist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusorygeInfo>> buildActionsOnPassedHook(DeciTreeOption<StusorygeInfo> option) {
		List<ActionStd<StusorygeInfo>> actions = new ArrayList<>();

		ActionStd<StusorygeInfo> mergeOrdist = new ActionStdCommom<StusorygeInfo>(option, StusorygeVisiMergeOrdist.class);
		ActionLazy<StusorygeInfo> upsert = new ActionLazyCommom<StusorygeInfo>(option, StusorygeVisiRootUpsert.class);
		
		mergeOrdist.addPostAction(upsert);
		
		actions.add(mergeOrdist);
		return actions;
	}
}
