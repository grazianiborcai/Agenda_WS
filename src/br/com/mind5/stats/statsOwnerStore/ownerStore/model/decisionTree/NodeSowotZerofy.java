package br.com.mind5.stats.statsOwnerStore.ownerStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStore.model.action.StdSowotEnforceZerofy;
import br.com.mind5.stats.statsOwnerStore.ownerStore.model.action.StdSowotSuccess;
import br.com.mind5.stats.statsOwnerStore.ownerStore.model.checker.SowotCheckHasData;


public final class NodeSowotZerofy extends DeciTreeTemplateWrite<SowotInfo> {
	
	public NodeSowotZerofy(DeciTreeOption<SowotInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowotInfo> buildCheckerHook(DeciTreeOption<SowotInfo> option) {
		List<ModelChecker<SowotInfo>> queue = new ArrayList<>();		
		ModelChecker<SowotInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowotCheckHasData(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowotInfo>> buildActionsOnPassedHook(DeciTreeOption<SowotInfo> option) {
		List<ActionStd<SowotInfo>> actions = new ArrayList<>();

		ActionStd<SowotInfo> success = new StdSowotSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowotInfo>> buildActionsOnFailedHook(DeciTreeOption<SowotInfo> option) {
		List<ActionStd<SowotInfo>> actions = new ArrayList<>();

		ActionStd<SowotInfo> zerofy = new StdSowotEnforceZerofy(option);
		
		actions.add(zerofy);
		return actions;
	}
}
