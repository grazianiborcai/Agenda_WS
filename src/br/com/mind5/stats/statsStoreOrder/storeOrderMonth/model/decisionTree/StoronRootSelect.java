package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.checker.StoronCheckRead;


public final class StoronRootSelect extends DeciTreeTemplateWrite<StoronInfo> {
	
	public StoronRootSelect(DeciTreeOption<StoronInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoronInfo> buildCheckerHook(DeciTreeOption<StoronInfo> option) {
		List<ModelChecker<StoronInfo>> queue = new ArrayList<>();
		ModelChecker<StoronInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StoronCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoronInfo>> buildActionsOnPassedHook(DeciTreeOption<StoronInfo> option) {
		List<ActionStd<StoronInfo>> actions = new ArrayList<>();

		ActionStd<StoronInfo> nodeL1 = new StoronNodeSelectL1(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
