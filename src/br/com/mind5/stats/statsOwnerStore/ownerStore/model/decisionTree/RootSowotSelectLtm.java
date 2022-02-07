package br.com.mind5.stats.statsOwnerStore.ownerStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStore.model.action.LazySowotNodeSelectLtm;
import br.com.mind5.stats.statsOwnerStore.ownerStore.model.action.LazySowotNodeZerofy;
import br.com.mind5.stats.statsOwnerStore.ownerStore.model.action.StdSowotMergeCalonthLtm;


public final class RootSowotSelectLtm extends DeciTreeTemplateWrite<SowotInfo> {
	
	public RootSowotSelectLtm(DeciTreeOption<SowotInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowotInfo> buildCheckerHook(DeciTreeOption<SowotInfo> option) {
		List<ModelChecker<SowotInfo>> queue = new ArrayList<>();		
		ModelChecker<SowotInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowotInfo>> buildActionsOnPassedHook(DeciTreeOption<SowotInfo> option) {
		List<ActionStd<SowotInfo>> actions = new ArrayList<>();

		ActionStd<SowotInfo> mergeCalonthLtm = new StdSowotMergeCalonthLtm(option);
		ActionLazy<SowotInfo> nodeL1 = new LazySowotNodeSelectLtm(option.conn, option.schemaName);
		ActionLazy<SowotInfo> zerofy = new LazySowotNodeZerofy(option.conn, option.schemaName);		
		
		mergeCalonthLtm.addPostAction(nodeL1);
		nodeL1.addPostAction(zerofy);
		
		actions.add(mergeCalonthLtm);
		return actions;
	}
}
