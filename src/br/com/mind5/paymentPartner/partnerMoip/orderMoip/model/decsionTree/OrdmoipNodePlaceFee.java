package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiNodePlaceL2;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiNodeSysparL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiEnforceFeeTxt;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiEnforceReceiverSys;

public final class OrdmoipNodePlaceFee extends DeciTreeTemplateWrite<OrdmoipInfo> {
	
	public OrdmoipNodePlaceFee(DeciTreeOption<OrdmoipInfo> option) {
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
		
		ActionStd<OrdmoipInfo> enforceFeeTxt = new ActionStdCommom<OrdmoipInfo>(option, OrdmoipVisiEnforceFeeTxt.class);	
		ActionLazy<OrdmoipInfo> nodeSyspar = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiNodeSysparL1.class);
		ActionLazy<OrdmoipInfo> enforceReceiverSys = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiEnforceReceiverSys.class);
		ActionLazy<OrdmoipInfo> nodeL2 = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiNodePlaceL2.class);
		
		
		enforceFeeTxt.addPostAction(nodeSyspar);
		nodeSyspar.addPostAction(enforceReceiverSys);
		enforceReceiverSys.addPostAction(nodeL2);
		
		actions.add(enforceFeeTxt);		
		return actions;
	}
}
