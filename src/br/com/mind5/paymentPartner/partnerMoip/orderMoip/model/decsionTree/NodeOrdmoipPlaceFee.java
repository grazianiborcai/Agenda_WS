package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceReceiverSys;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodePlaceL2;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodeSysparL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.StdOrdmoipEnforceFeeTxt;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker.OrdmoipCheckDummy;

public final class NodeOrdmoipPlaceFee extends DeciTreeWriteTemplate<OrdmoipInfo> {
	
	public NodeOrdmoipPlaceFee(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildDecisionCheckerHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;	
	
		checker = new OrdmoipCheckDummy();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {		
		List<ActionStdV1<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<OrdmoipInfo> enforceFeeTxt = new StdOrdmoipEnforceFeeTxt(option);	
		ActionLazyV1<OrdmoipInfo> nodeSyspar = new LazyOrdmoipNodeSysparL1(option.conn, option.schemaName);
		ActionLazyV1<OrdmoipInfo> enforceReceiverSys = new LazyOrdmoipEnforceReceiverSys(option.conn, option.schemaName);
		ActionLazyV1<OrdmoipInfo> nodeL2 = new LazyOrdmoipNodePlaceL2(option.conn, option.schemaName);
		
		
		enforceFeeTxt.addPostAction(nodeSyspar);
		nodeSyspar.addPostAction(enforceReceiverSys);
		enforceReceiverSys.addPostAction(nodeL2);
		
		actions.add(enforceFeeTxt);		
		return actions;
	}
}
