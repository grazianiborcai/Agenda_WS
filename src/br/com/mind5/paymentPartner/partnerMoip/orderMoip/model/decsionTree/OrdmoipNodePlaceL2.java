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
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiEnforceAccount;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiEnforceAmount;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiEnforceCustomer;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiEnforceItemNum;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiEnforceOrder;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiEnforceOwnId;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiEnforceProducts;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiEnforceReceivers;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiEnforceSubtotal;

public final class OrdmoipNodePlaceL2 extends DeciTreeTemplateWrite<OrdmoipInfo> {
	
	public OrdmoipNodePlaceL2(DeciTreeOption<OrdmoipInfo> option) {
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

		ActionStd<OrdmoipInfo> enforceItemNum = new ActionStdCommom<OrdmoipInfo>(option, OrdmoipVisiEnforceItemNum.class);	
		ActionLazy<OrdmoipInfo> enforceSubtotal = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiEnforceSubtotal.class);	
		ActionLazy<OrdmoipInfo> enforceAmount = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiEnforceAmount.class);
		ActionLazy<OrdmoipInfo> enforceProducts = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiEnforceProducts.class);
		ActionLazy<OrdmoipInfo> enforceAccount = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiEnforceAccount.class);
		ActionLazy<OrdmoipInfo> enforceReceivers = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiEnforceReceivers.class);
		ActionLazy<OrdmoipInfo> enforceCustomer = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiEnforceCustomer.class);
		ActionLazy<OrdmoipInfo> enforceOwnId = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiEnforceOwnId.class);
		ActionLazy<OrdmoipInfo> enforceOrder = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiEnforceOrder.class);
		
		enforceItemNum.addPostAction(enforceSubtotal);
		enforceSubtotal.addPostAction(enforceAmount);
		enforceAmount.addPostAction(enforceProducts);
		enforceProducts.addPostAction(enforceAccount);
		enforceAccount.addPostAction(enforceReceivers);
		enforceReceivers.addPostAction(enforceCustomer);		
		enforceCustomer.addPostAction(enforceOwnId);
		enforceOwnId.addPostAction(enforceOrder);
		
		actions.add(enforceItemNum);		
		return actions;
	}
}
