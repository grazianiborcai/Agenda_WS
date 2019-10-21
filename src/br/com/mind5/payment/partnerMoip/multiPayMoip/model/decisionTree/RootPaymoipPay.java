package br.com.mind5.payment.partnerMoip.multiPayMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.action.LazyPaymoipCard;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforceFunding;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforcePayment;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforceResponseAttr;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforceSetup;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.action.LazyPaymoipMergeSysEnviron;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.action.StdPaymoipEnforceCard;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.check.PaymoipCheckCrecardData;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.check.PaymoipCheckPay;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.check.PaymoipCheckSysparData;

public final class RootPaymoipPay extends DeciTreeWriteTemplate<PaymoipInfo> {
	
	public RootPaymoipPay(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaymoipInfo> buildDecisionCheckerHook(DeciTreeOption<PaymoipInfo> option) {	
		List<ModelChecker<PaymoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PaymoipInfo> checker;
		
		checker = new PaymoipCheckPay();
		queue.add(checker);
		
		checker = new PaymoipCheckCrecardData();
		queue.add(checker);
		
		checker = new PaymoipCheckSysparData();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaymoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymoipInfo> option) {
		List<ActionStd<PaymoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<PaymoipInfo> enforceCard = new StdPaymoipEnforceCard(option);
		ActionLazy<PaymoipInfo> enforceFunding = new LazyPaymoipEnforceFunding(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> enforcePayment = new LazyPaymoipEnforcePayment(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> mergeSysEnviron = new LazyPaymoipMergeSysEnviron(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> enforceSetup = new LazyPaymoipEnforceSetup(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> payWithCredicard = new LazyPaymoipCard(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> enforceReponseAttr = new LazyPaymoipEnforceResponseAttr(option.conn, option.schemaName);
		
		enforceCard.addPostAction(enforceFunding);
		enforceFunding.addPostAction(enforcePayment);
		enforcePayment.addPostAction(mergeSysEnviron);
		mergeSysEnviron.addPostAction(enforceSetup);
		enforceSetup.addPostAction(payWithCredicard);
		payWithCredicard.addPostAction(enforceReponseAttr);
		
		actions.add(enforceCard);		
		return actions;
	}
}
