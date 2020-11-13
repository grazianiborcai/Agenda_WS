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
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceReceiverSys;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodePlaceL2;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodeSysparL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.StdOrdmoipEnforceFeeTxt;

public final class NodeOrdmoipPlaceFee extends DeciTreeTemplateWrite<OrdmoipInfo> {
	
	public NodeOrdmoipPlaceFee(DeciTreeOption<OrdmoipInfo> option) {
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
		
		ActionStd<OrdmoipInfo> enforceFeeTxt = new StdOrdmoipEnforceFeeTxt(option);	
		ActionLazy<OrdmoipInfo> nodeSyspar = new LazyOrdmoipNodeSysparL1(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceReceiverSys = new LazyOrdmoipEnforceReceiverSys(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> nodeL2 = new LazyOrdmoipNodePlaceL2(option.conn, option.schemaName);
		
		
		enforceFeeTxt.addPostAction(nodeSyspar);
		nodeSyspar.addPostAction(enforceReceiverSys);
		enforceReceiverSys.addPostAction(nodeL2);
		
		actions.add(enforceFeeTxt);		
		return actions;
	}
}
