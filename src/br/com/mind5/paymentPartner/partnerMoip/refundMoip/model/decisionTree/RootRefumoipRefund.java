package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipMergePayordemist;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipNodeRefundL1;
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

		return new ModelCheckerQueue<>(queue);
	}
	
	
	//TODO: verificar refund duas vezes
	@Override protected List<ActionStdV1<RefumoipInfo>> buildActionsOnPassedHook(DeciTreeOption<RefumoipInfo> option) {
		List<ActionStdV1<RefumoipInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<RefumoipInfo> enforcePaypar = new StdRefumoipEnforcePaypar(option);	
		ActionLazyV1<RefumoipInfo> mergePayordemist = new LazyRefumoipMergePayordemist(option.conn, option.schemaName);	
		ActionLazyV1<RefumoipInfo> nodeRefund = new LazyRefumoipNodeRefundL1(option.conn, option.schemaName);		
		ActionLazyV1<RefumoipInfo> refund = new LazyRefumoipRefund(option.conn, option.schemaName);
		ActionLazyV1<RefumoipInfo> enforceResponseAttr = new LazyRefumoipEnforceResponseAttr(option.conn, option.schemaName);
		
		enforcePaypar.addPostAction(mergePayordemist);
		mergePayordemist.addPostAction(nodeRefund);
		nodeRefund.addPostAction(refund);
		refund.addPostAction(enforceResponseAttr);
		
		actions.add(enforcePaypar);		
		return actions;
	}
}
