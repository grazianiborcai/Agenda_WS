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
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiNodeStoparL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiEnforceMatTxt;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiEnforceReceiverStore;

public final class OrdmoipNodePlaceMat extends DeciTreeTemplateWrite<OrdmoipInfo> {
	
	public OrdmoipNodePlaceMat(DeciTreeOption<OrdmoipInfo> option) {
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
		
		ActionStd<OrdmoipInfo> enforceMatTxt = new ActionStdCommom<OrdmoipInfo>(option, OrdmoipVisiEnforceMatTxt.class);	
		ActionLazy<OrdmoipInfo> nodeStopar = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiNodeStoparL1.class);
		ActionLazy<OrdmoipInfo> enforceReceiverStore = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiEnforceReceiverStore.class);
		ActionLazy<OrdmoipInfo> nodeL2 = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiNodePlaceL2.class);		
		
		enforceMatTxt.addPostAction(nodeStopar);
		nodeStopar.addPostAction(enforceReceiverStore);
		enforceReceiverStore.addPostAction(nodeL2);
		
		actions.add(enforceMatTxt);		
		return actions;
	}
}
