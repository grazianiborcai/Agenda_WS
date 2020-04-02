package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipCard;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforceCard;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforceFunding;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforcePayment;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipMergeSysEnviron;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipNodeCrecardL1;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipNodeSetuparL1;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipNodeSysparL1;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.StdPaymoipEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.checker.PaymoipCheckPay;

public final class RootPaymoipPay extends DeciTreeWriteTemplate<PaymoipInfo> {
	
	public RootPaymoipPay(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaymoipInfo> buildDecisionCheckerHook(DeciTreeOption<PaymoipInfo> option) {	
		List<ModelChecker<PaymoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PaymoipInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new PaymoipCheckPay(checkerOption);
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PaymoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymoipInfo> option) {
		List<ActionStdV1<PaymoipInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<PaymoipInfo> enforcePaypar = new StdPaymoipEnforcePaypar(option);
		ActionLazyV1<PaymoipInfo> nodeCrecard = new LazyPaymoipNodeCrecardL1(option.conn, option.schemaName);
		ActionLazyV1<PaymoipInfo> nodeSyspar = new LazyPaymoipNodeSysparL1(option.conn, option.schemaName);
		ActionLazyV1<PaymoipInfo> nodeSetupar = new LazyPaymoipNodeSetuparL1(option.conn, option.schemaName);
		ActionLazyV1<PaymoipInfo> enforceCard = new LazyPaymoipEnforceCard(option.conn, option.schemaName);
		ActionLazyV1<PaymoipInfo> enforceFunding = new LazyPaymoipEnforceFunding(option.conn, option.schemaName);
		ActionLazyV1<PaymoipInfo> enforcePayment = new LazyPaymoipEnforcePayment(option.conn, option.schemaName);
		ActionLazyV1<PaymoipInfo> mergeSysEnviron = new LazyPaymoipMergeSysEnviron(option.conn, option.schemaName);
		ActionLazyV1<PaymoipInfo> enforceSetup = new LazyPaymoipEnforceSetup(option.conn, option.schemaName);
		ActionLazyV1<PaymoipInfo> payWithCredicard = new LazyPaymoipCard(option.conn, option.schemaName);
		ActionLazyV1<PaymoipInfo> enforceReponseAttr = new LazyPaymoipEnforceResponseAttr(option.conn, option.schemaName);
		
		enforcePaypar.addPostAction(nodeCrecard);
		nodeCrecard.addPostAction(nodeSyspar);
		nodeSyspar.addPostAction(nodeSetupar);
		nodeSetupar.addPostAction(enforceCard);
		enforceCard.addPostAction(enforceFunding);
		enforceFunding.addPostAction(enforcePayment);
		enforcePayment.addPostAction(mergeSysEnviron);
		mergeSysEnviron.addPostAction(enforceSetup);
		enforceSetup.addPostAction(payWithCredicard);
		payWithCredicard.addPostAction(enforceReponseAttr);
		
		actions.add(enforcePaypar);		
		return actions;
	}
}
