package br.com.mind5.stats.statsOwnerSale.ownerSale.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.action.LazySowalNodeSelectLtm;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.action.LazySowalNodeZerofy;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.action.StdSowalMergeCalonthLtm;


public final class RootSowalSelectLtm extends DeciTreeTemplateWrite<SowalInfo> {
	
	public RootSowalSelectLtm(DeciTreeOption<SowalInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowalInfo> buildCheckerHook(DeciTreeOption<SowalInfo> option) {
		List<ModelChecker<SowalInfo>> queue = new ArrayList<>();		
		ModelChecker<SowalInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowalInfo>> buildActionsOnPassedHook(DeciTreeOption<SowalInfo> option) {
		List<ActionStd<SowalInfo>> actions = new ArrayList<>();

		ActionStd<SowalInfo> mergeCalonthLtm = new StdSowalMergeCalonthLtm(option);
		ActionLazy<SowalInfo> nodeL1 = new LazySowalNodeSelectLtm(option.conn, option.schemaName);
		ActionLazy<SowalInfo> zerofy = new LazySowalNodeZerofy(option.conn, option.schemaName);		
		
		mergeCalonthLtm.addPostAction(nodeL1);
		nodeL1.addPostAction(zerofy);
		
		actions.add(mergeCalonthLtm);
		return actions;
	}
}
