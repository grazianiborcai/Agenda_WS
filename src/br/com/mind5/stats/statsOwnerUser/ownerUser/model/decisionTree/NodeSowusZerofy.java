package br.com.mind5.stats.statsOwnerUser.ownerUser.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerUser.ownerUser.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUser.model.action.StdSowusEnforceZerofy;
import br.com.mind5.stats.statsOwnerUser.ownerUser.model.action.StdSowusSuccess;
import br.com.mind5.stats.statsOwnerUser.ownerUser.model.checker.SowusCheckHasData;


public final class NodeSowusZerofy extends DeciTreeTemplateWrite<SowusInfo> {
	
	public NodeSowusZerofy(DeciTreeOption<SowusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowusInfo> buildCheckerHook(DeciTreeOption<SowusInfo> option) {
		List<ModelChecker<SowusInfo>> queue = new ArrayList<>();		
		ModelChecker<SowusInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowusCheckHasData(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowusInfo>> buildActionsOnPassedHook(DeciTreeOption<SowusInfo> option) {
		List<ActionStd<SowusInfo>> actions = new ArrayList<>();

		ActionStd<SowusInfo> success = new StdSowusSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowusInfo>> buildActionsOnFailedHook(DeciTreeOption<SowusInfo> option) {
		List<ActionStd<SowusInfo>> actions = new ArrayList<>();

		ActionStd<SowusInfo> zerofy = new StdSowusEnforceZerofy(option);
		
		actions.add(zerofy);
		return actions;
	}
}
