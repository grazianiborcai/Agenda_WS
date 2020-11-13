package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceReceiverSys;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodePlaceL2;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodeSysparL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.StdOrdmoipEnforceFeeTxt;

public final class NodeOrdmoipPlaceFee extends DeciTreeTemplateWriteV2<OrdmoipInfo> {
	
	public NodeOrdmoipPlaceFee(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrdmoipInfo> buildCheckerHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ModelCheckerV1<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrdmoipInfo> checker;	
	
		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {		
		List<ActionStdV1<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<OrdmoipInfo> enforceFeeTxt = new StdOrdmoipEnforceFeeTxt(option);	
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
