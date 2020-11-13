package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceReceiverStore;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodePlaceL2;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodeStoparL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.StdOrdmoipEnforceMatTxt;

public final class NodeOrdmoipPlaceMat extends DeciTreeTemplateWrite<OrdmoipInfo> {
	
	public NodeOrdmoipPlaceMat(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildCheckerHook(DeciTreeOption<OrdmoipInfo> option) {			
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<OrdmoipInfo> enforceMatTxt = new StdOrdmoipEnforceMatTxt(option);	
		ActionLazy<OrdmoipInfo> nodeStopar = new LazyOrdmoipNodeStoparL1(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceReceiverStore = new LazyOrdmoipEnforceReceiverStore(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> nodeL2 = new LazyOrdmoipNodePlaceL2(option.conn, option.schemaName);		
		
		enforceMatTxt.addPostAction(nodeStopar);
		nodeStopar.addPostAction(enforceReceiverStore);
		enforceReceiverStore.addPostAction(nodeL2);
		
		actions.add(enforceMatTxt);		
		return actions;
	}
}
