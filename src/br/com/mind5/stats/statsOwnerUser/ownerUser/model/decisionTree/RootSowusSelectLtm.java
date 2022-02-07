package br.com.mind5.stats.statsOwnerUser.ownerUser.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerUser.ownerUser.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUser.model.action.LazySowusNodeSelectLtm;
import br.com.mind5.stats.statsOwnerUser.ownerUser.model.action.LazySowusNodeZerofy;
import br.com.mind5.stats.statsOwnerUser.ownerUser.model.action.StdSowusMergeCalonthLtm;


public final class RootSowusSelectLtm extends DeciTreeTemplateWrite<SowusInfo> {
	
	public RootSowusSelectLtm(DeciTreeOption<SowusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowusInfo> buildCheckerHook(DeciTreeOption<SowusInfo> option) {
		List<ModelChecker<SowusInfo>> queue = new ArrayList<>();		
		ModelChecker<SowusInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowusInfo>> buildActionsOnPassedHook(DeciTreeOption<SowusInfo> option) {
		List<ActionStd<SowusInfo>> actions = new ArrayList<>();

		ActionStd<SowusInfo> mergeCalonthLtm = new StdSowusMergeCalonthLtm(option);
		ActionLazy<SowusInfo> nodeL1 = new LazySowusNodeSelectLtm(option.conn, option.schemaName);
		ActionLazy<SowusInfo> zerofy = new LazySowusNodeZerofy(option.conn, option.schemaName);		
		
		mergeCalonthLtm.addPostAction(nodeL1);
		nodeL1.addPostAction(zerofy);
		
		actions.add(mergeCalonthLtm);
		return actions;
	}
}
