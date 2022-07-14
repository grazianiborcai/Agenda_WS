package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action.StoronVisiMergeStoronagr;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.checker.StoronCheckStoronagr;


public final class StoronNodeSelectL1 extends DeciTreeTemplateWrite<StoronInfo> {
	
	public StoronNodeSelectL1(DeciTreeOption<StoronInfo> option) {
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
		checker = new StoronCheckStoronagr(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoronInfo>> buildActionsOnPassedHook(DeciTreeOption<StoronInfo> option) {
		List<ActionStd<StoronInfo>> actions = new ArrayList<>();

		ActionStd<StoronInfo> mergeSteddagr = new ActionStdCommom<StoronInfo>(option, StoronVisiMergeStoronagr.class);
		
		actions.add(mergeSteddagr);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StoronInfo>> buildActionsOnFailedHook(DeciTreeOption<StoronInfo> option) {
		List<ActionStd<StoronInfo>> actions = new ArrayList<>();

		ActionStd<StoronInfo> nodeL2 = new StoronNodeSelectL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
}
