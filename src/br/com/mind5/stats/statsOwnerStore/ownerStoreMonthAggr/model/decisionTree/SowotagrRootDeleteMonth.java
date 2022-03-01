package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.checker.SowotagrCheckDeleteMonth;


public final class SowotagrRootDeleteMonth extends DeciTreeTemplateWrite<SowotagrInfo> {
	
	public SowotagrRootDeleteMonth(DeciTreeOption<SowotagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowotagrInfo> buildCheckerHook(DeciTreeOption<SowotagrInfo> option) {
		List<ModelChecker<SowotagrInfo>> queue = new ArrayList<>();
		ModelChecker<SowotagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowotagrCheckDeleteMonth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowotagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowotagrInfo> option) {
		List<ActionStd<SowotagrInfo>> actions = new ArrayList<>();

		ActionStd<SowotagrInfo> nodeL1 = new SowotagrNodeDeleteMonth(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
