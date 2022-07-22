package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiNodeCrecardL1;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiNodeSetuparL1;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiNodeSysparL1;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiCard;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiEnforceCard;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiEnforceFunding;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiEnforcePayment;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.checker.PaymoipCheckPay;

public final class PaymoipRootPay extends DeciTreeTemplateWrite<PaymoipInfo> {
	
	public PaymoipRootPay(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaymoipInfo> buildCheckerHook(DeciTreeOption<PaymoipInfo> option) {	
		List<ModelChecker<PaymoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PaymoipInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new PaymoipCheckPay(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaymoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymoipInfo> option) {
		List<ActionStd<PaymoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<PaymoipInfo> enforcePaypar = new ActionStdCommom<PaymoipInfo>(option, PaymoipVisiEnforcePaypar.class);
		ActionLazy<PaymoipInfo> nodeCrecard = new ActionLazyCommom<PaymoipInfo>(option, PaymoipVisiNodeCrecardL1.class);
		ActionLazy<PaymoipInfo> nodeSyspar = new ActionLazyCommom<PaymoipInfo>(option, PaymoipVisiNodeSysparL1.class);
		ActionLazy<PaymoipInfo> nodeSetupar = new ActionLazyCommom<PaymoipInfo>(option, PaymoipVisiNodeSetuparL1.class);
		ActionLazy<PaymoipInfo> enforceCard = new ActionLazyCommom<PaymoipInfo>(option, PaymoipVisiEnforceCard.class);
		ActionLazy<PaymoipInfo> enforceFunding = new ActionLazyCommom<PaymoipInfo>(option, PaymoipVisiEnforceFunding.class);
		ActionLazy<PaymoipInfo> enforcePayment = new ActionLazyCommom<PaymoipInfo>(option, PaymoipVisiEnforcePayment.class);
		ActionLazy<PaymoipInfo> mergeSysenv = new ActionLazyCommom<PaymoipInfo>(option, PaymoipVisiMergeSysenv.class);
		ActionLazy<PaymoipInfo> enforceSetup = new ActionLazyCommom<PaymoipInfo>(option, PaymoipVisiEnforceSetup.class);
		ActionLazy<PaymoipInfo> payWithCredicard = new ActionLazyCommom<PaymoipInfo>(option, PaymoipVisiCard.class);
		ActionLazy<PaymoipInfo> enforceReponseAttr = new ActionLazyCommom<PaymoipInfo>(option, PaymoipVisiEnforceResponseAttr.class);
		
		enforcePaypar.addPostAction(nodeCrecard);
		nodeCrecard.addPostAction(nodeSyspar);
		nodeSyspar.addPostAction(nodeSetupar);
		nodeSetupar.addPostAction(enforceCard);
		enforceCard.addPostAction(enforceFunding);
		enforceFunding.addPostAction(enforcePayment);
		enforcePayment.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);
		enforceSetup.addPostAction(payWithCredicard);
		payWithCredicard.addPostAction(enforceReponseAttr);
		
		actions.add(enforcePaypar);		
		return actions;
	}
}
