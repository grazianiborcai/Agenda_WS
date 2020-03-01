package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipNodeRefund;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipRefund;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.StdRefumoipEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.checker.RefumoipCheckRefund;

public final class RootRefumoipRefund extends DeciTreeWriteTemplate<RefumoipInfo> {
	
	public RootRefumoipRefund(DeciTreeOption<RefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefumoipInfo> buildDecisionCheckerHook(DeciTreeOption<RefumoipInfo> option) {		
		List<ModelChecker<RefumoipInfo>> queue = new ArrayList<>();		
		ModelChecker<RefumoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefumoipCheckRefund(checkerOption);
		queue.add(checker);
		//TODO: verificar partner = MOIP
		return new ModelCheckerQueue<>(queue);
	}
	
	
	//TODO: verificar refund duas vezes
	@Override protected List<ActionStd<RefumoipInfo>> buildActionsOnPassedHook(DeciTreeOption<RefumoipInfo> option) {
		List<ActionStd<RefumoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<RefumoipInfo> enforcePaypar = new StdRefumoipEnforcePaypar(option);	
		ActionLazy<RefumoipInfo> nodeRefund = new LazyRefumoipNodeRefund(option.conn, option.schemaName);		
		ActionLazy<RefumoipInfo> refund = new LazyRefumoipRefund(option.conn, option.schemaName);
		ActionLazy<RefumoipInfo> enforceResponseAttr = new LazyRefumoipEnforceResponseAttr(option.conn, option.schemaName);
		
		enforcePaypar.addPostAction(nodeRefund);
		nodeRefund.addPostAction(refund);
		refund.addPostAction(enforceResponseAttr);
		
		actions.add(enforcePaypar);		
		return actions;
	}
}
