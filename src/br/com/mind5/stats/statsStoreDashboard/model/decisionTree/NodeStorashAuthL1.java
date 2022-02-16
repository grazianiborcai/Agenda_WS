package br.com.mind5.stats.statsStoreDashboard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;
import br.com.mind5.stats.statsStoreDashboard.model.action.StdStorashSuccess;
import br.com.mind5.stats.statsStoreDashboard.model.checker.StorashCheckAuthOwner;

public final class NodeStorashAuthL1 extends DeciTreeTemplateWrite<StorashInfo> {
	
	public NodeStorashAuthL1(DeciTreeOption<StorashInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorashInfo> buildCheckerHook(DeciTreeOption<StorashInfo> option) {
		List<ModelChecker<StorashInfo>> queue = new ArrayList<>();		
		ModelChecker<StorashInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorashCheckAuthOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorashInfo>> buildActionsOnPassedHook(DeciTreeOption<StorashInfo> option) {
		List<ActionStd<StorashInfo>> actions = new ArrayList<>();
		
		ActionStd<StorashInfo> success = new StdStorashSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StorashInfo>> buildActionsOnFailedHook(DeciTreeOption<StorashInfo> option) {
		List<ActionStd<StorashInfo>> actions = new ArrayList<>();
		
		ActionStd<StorashInfo> nodeL2 = new NodeStorashAuthL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
}
