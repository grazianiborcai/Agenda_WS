package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action.StdSowordMergeSowordagr;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.checker.SowordCheckSowordagr;


public final class NodeSowordSelectL1 extends DeciTreeTemplateWrite<SowordInfo> {
	
	public NodeSowordSelectL1(DeciTreeOption<SowordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowordInfo> buildCheckerHook(DeciTreeOption<SowordInfo> option) {
		List<ModelChecker<SowordInfo>> queue = new ArrayList<>();
		ModelChecker<SowordInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowordCheckSowordagr(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowordInfo>> buildActionsOnPassedHook(DeciTreeOption<SowordInfo> option) {
		List<ActionStd<SowordInfo>> actions = new ArrayList<>();

		ActionStd<SowordInfo> mergeSowordagr = new StdSowordMergeSowordagr(option);
		
		actions.add(mergeSowordagr);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowordInfo>> buildActionsOnFailedHook(DeciTreeOption<SowordInfo> option) {
		List<ActionStd<SowordInfo>> actions = new ArrayList<>();

		ActionStd<SowordInfo> nodeL2 = new NodeSowordSelectL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
}
