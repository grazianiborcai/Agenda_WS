package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.decisionTree;

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
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action.StordVisiEnforceZerofy;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action.StordVisiMergeStolis;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action.StordVisiMergeStordive;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action.StordVisiStordagrInsert;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.checker.StordCheckStordive;


public final class StordNodeSelectL2 extends DeciTreeTemplateWrite<StordInfo> {
	
	public StordNodeSelectL2(DeciTreeOption<StordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StordInfo> buildCheckerHook(DeciTreeOption<StordInfo> option) {
		List<ModelChecker<StordInfo>> queue = new ArrayList<>();
		ModelChecker<StordInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StordCheckStordive(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StordInfo>> buildActionsOnPassedHook(DeciTreeOption<StordInfo> option) {
		List<ActionStd<StordInfo>> actions = new ArrayList<>();

		ActionStd<StordInfo> mergeStordive = new ActionStdCommom<StordInfo>(option, StordVisiMergeStordive.class);
		ActionLazy<StordInfo> insertStordagr = new ActionLazyCommom<StordInfo>(option, StordVisiStordagrInsert.class);
		
		mergeStordive.addPostAction(insertStordagr);		
		
		actions.add(mergeStordive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StordInfo>> buildActionsOnFailedHook(DeciTreeOption<StordInfo> option) {
		List<ActionStd<StordInfo>> actions = new ArrayList<>();

		ActionStd<StordInfo> zerofy = new ActionStdCommom<StordInfo>(option, StordVisiEnforceZerofy.class);
		ActionLazy<StordInfo> mergeStolis = new ActionLazyCommom<StordInfo>(option, StordVisiMergeStolis.class);
		ActionLazy<StordInfo> insertStordagr = new ActionLazyCommom<StordInfo>(option, StordVisiStordagrInsert.class);
		
		zerofy.addPostAction(mergeStolis);
		mergeStolis.addPostAction(insertStordagr);
		
		actions.add(zerofy);
		return actions;
	}
}
