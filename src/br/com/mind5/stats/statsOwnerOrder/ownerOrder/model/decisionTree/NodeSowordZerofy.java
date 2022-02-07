package br.com.mind5.stats.statsOwnerOrder.ownerOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.model.action.StdSowordEnforceZerofy;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.model.action.StdSowordSuccess;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.model.checker.SowordCheckHasData;


public final class NodeSowordZerofy extends DeciTreeTemplateWrite<SowordInfo> {
	
	public NodeSowordZerofy(DeciTreeOption<SowordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowordInfo> buildCheckerHook(DeciTreeOption<SowordInfo> option) {
		List<ModelChecker<SowordInfo>> queue = new ArrayList<>();		
		ModelChecker<SowordInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowordCheckHasData(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowordInfo>> buildActionsOnPassedHook(DeciTreeOption<SowordInfo> option) {
		List<ActionStd<SowordInfo>> actions = new ArrayList<>();

		ActionStd<SowordInfo> success = new StdSowordSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowordInfo>> buildActionsOnFailedHook(DeciTreeOption<SowordInfo> option) {
		List<ActionStd<SowordInfo>> actions = new ArrayList<>();

		ActionStd<SowordInfo> zerofy = new StdSowordEnforceZerofy(option);
		
		actions.add(zerofy);
		return actions;
	}
}
