package br.com.mind5.stats.statsOwnerOrder.ownerOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.model.action.LazySowordNodeSelectLtm;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.model.action.LazySowordNodeZerofy;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.model.action.StdSowordMergeCalonthLtm;


public final class RootSowordSelectLtm extends DeciTreeTemplateWrite<SowordInfo> {
	
	public RootSowordSelectLtm(DeciTreeOption<SowordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowordInfo> buildCheckerHook(DeciTreeOption<SowordInfo> option) {
		List<ModelChecker<SowordInfo>> queue = new ArrayList<>();		
		ModelChecker<SowordInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowordInfo>> buildActionsOnPassedHook(DeciTreeOption<SowordInfo> option) {
		List<ActionStd<SowordInfo>> actions = new ArrayList<>();

		ActionStd<SowordInfo> mergeCalonthLtm = new StdSowordMergeCalonthLtm(option);
		ActionLazy<SowordInfo> nodeL1 = new LazySowordNodeSelectLtm(option.conn, option.schemaName);
		ActionLazy<SowordInfo> zerofy = new LazySowordNodeZerofy(option.conn, option.schemaName);		
		
		mergeCalonthLtm.addPostAction(nodeL1);
		nodeL1.addPostAction(zerofy);
		
		actions.add(mergeCalonthLtm);
		return actions;
	}
}
