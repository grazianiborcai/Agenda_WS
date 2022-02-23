package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action.LazySteddMergeStolis;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action.LazyStordStordagrInsert;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action.StdStordEnforceZerofy;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action.StdStordMergeStordive;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.checker.StordCheckStordive;


public final class NodeStordSelectL2 extends DeciTreeTemplateWrite<StordInfo> {
	
	public NodeStordSelectL2(DeciTreeOption<StordInfo> option) {
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

		ActionStd<StordInfo> mergeSteddive = new StdStordMergeStordive(option);
		ActionLazy<StordInfo> insertSteddagr = new LazyStordStordagrInsert(option.conn, option.schemaName);
		
		mergeSteddive.addPostAction(insertSteddagr);
		
		
		actions.add(mergeSteddive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StordInfo>> buildActionsOnFailedHook(DeciTreeOption<StordInfo> option) {
		List<ActionStd<StordInfo>> actions = new ArrayList<>();

		ActionStd<StordInfo> zerofy = new StdStordEnforceZerofy(option);
		ActionLazy<StordInfo> mergeStolis = new LazySteddMergeStolis(option.conn, option.schemaName);
		ActionLazy<StordInfo> insertSteddagr = new LazyStordStordagrInsert(option.conn, option.schemaName);
		
		zerofy.addPostAction(mergeStolis);
		mergeStolis.addPostAction(insertSteddagr);
		
		actions.add(zerofy);
		return actions;
	}
}
