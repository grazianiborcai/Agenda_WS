package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipMergePayordemist;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipNodeRefundL1;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipRefund;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.StdRefumoipEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.checker.RefumoipCheckRefund;

public final class RootRefumoipRefund extends DeciTreeTemplateWrite<RefumoipInfo> {
	
	public RootRefumoipRefund(DeciTreeOption<RefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefumoipInfo> buildCheckerHook(DeciTreeOption<RefumoipInfo> option) {		
		List<ModelChecker<RefumoipInfo>> queue = new ArrayList<>();		
		ModelChecker<RefumoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefumoipCheckRefund(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	//TODO: verificar refund duas vezes
	@Override protected List<ActionStd<RefumoipInfo>> buildActionsOnPassedHook(DeciTreeOption<RefumoipInfo> option) {
		List<ActionStd<RefumoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<RefumoipInfo> enforcePaypar = new StdRefumoipEnforcePaypar(option);	
		ActionLazy<RefumoipInfo> mergePayordemist = new LazyRefumoipMergePayordemist(option.conn, option.schemaName);	
		ActionLazy<RefumoipInfo> nodeRefund = new LazyRefumoipNodeRefundL1(option.conn, option.schemaName);		
		ActionLazy<RefumoipInfo> refund = new LazyRefumoipRefund(option.conn, option.schemaName);
		ActionLazy<RefumoipInfo> enforceResponseAttr = new LazyRefumoipEnforceResponseAttr(option.conn, option.schemaName);
		
		enforcePaypar.addPostAction(mergePayordemist);
		mergePayordemist.addPostAction(nodeRefund);
		nodeRefund.addPostAction(refund);
		refund.addPostAction(enforceResponseAttr);
		
		actions.add(enforcePaypar);		
		return actions;
	}
}
