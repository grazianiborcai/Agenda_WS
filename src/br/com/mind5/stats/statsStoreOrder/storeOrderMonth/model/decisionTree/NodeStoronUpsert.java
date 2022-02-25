package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action.LazyStoronMergeStolis;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action.LazyStoronStoronagrUpsert;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action.StdStoronEnforceZerofy;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action.StdStoronMergeStoronive;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.checker.StoronCheckStoronive;


public final class NodeStoronUpsert extends DeciTreeTemplateWrite<StoronInfo> {
	
	public NodeStoronUpsert(DeciTreeOption<StoronInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoronInfo> buildCheckerHook(DeciTreeOption<StoronInfo> option) {
		List<ModelChecker<StoronInfo>> queue = new ArrayList<>();
		ModelChecker<StoronInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StoronCheckStoronive(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoronInfo>> buildActionsOnPassedHook(DeciTreeOption<StoronInfo> option) {
		List<ActionStd<StoronInfo>> actions = new ArrayList<>();

		ActionStd<StoronInfo> mergeStoronive = new StdStoronMergeStoronive(option);
		ActionLazy<StoronInfo> upsertStoronagr = new LazyStoronStoronagrUpsert(option.conn, option.schemaName);
		
		mergeStoronive.addPostAction(upsertStoronagr);
		
		
		actions.add(mergeStoronive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StoronInfo>> buildActionsOnFailedHook(DeciTreeOption<StoronInfo> option) {
		List<ActionStd<StoronInfo>> actions = new ArrayList<>();

		ActionStd<StoronInfo> zerofy = new StdStoronEnforceZerofy(option);
		ActionLazy<StoronInfo> mergeStolis = new LazyStoronMergeStolis(option.conn, option.schemaName);
		ActionLazy<StoronInfo> upsertStoronagr = new LazyStoronStoronagrUpsert(option.conn, option.schemaName);
		
		zerofy.addPostAction(mergeStolis);
		mergeStolis.addPostAction(upsertStoronagr);
		
		
		actions.add(zerofy);
		return actions;
	}
}
