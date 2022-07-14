package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.decisionTree;

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
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action.StoronVisiEnforceZerofy;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action.StoronVisiMergeStolis;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action.StoronVisiMergeStoronive;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action.StoronVisiStoronagrInsert;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.checker.StoronCheckStoronive;


public final class StoronNodeSelectL2 extends DeciTreeTemplateWrite<StoronInfo> {
	
	public StoronNodeSelectL2(DeciTreeOption<StoronInfo> option) {
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

		ActionStd<StoronInfo> mergeSteddive = new ActionStdCommom<StoronInfo>(option, StoronVisiMergeStoronive.class);
		ActionLazy<StoronInfo> insertSteddagr = new ActionLazyCommom<StoronInfo>(option, StoronVisiStoronagrInsert.class);
		
		mergeSteddive.addPostAction(insertSteddagr);
		
		
		actions.add(mergeSteddive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StoronInfo>> buildActionsOnFailedHook(DeciTreeOption<StoronInfo> option) {
		List<ActionStd<StoronInfo>> actions = new ArrayList<>();

		ActionStd<StoronInfo> zerofy = new ActionStdCommom<StoronInfo>(option, StoronVisiEnforceZerofy.class);
		ActionLazy<StoronInfo> mergeStolis = new ActionLazyCommom<StoronInfo>(option, StoronVisiMergeStolis.class);
		ActionLazy<StoronInfo> insertStoronagr = new ActionLazyCommom<StoronInfo>(option, StoronVisiStoronagrInsert.class);
		
		zerofy.addPostAction(mergeStolis);
		mergeStolis.addPostAction(insertStoronagr);
		
		actions.add(zerofy);
		return actions;
	}
}
