package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipMergePayordemist;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipNodeRefundL1;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipRefund;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.StdRefumoipEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.checker.RefumoipCheckRefund;

public final class RootRefumoipRefund extends DeciTreeTemplateWriteV2<RefumoipInfo> {
	
	public RootRefumoipRefund(DeciTreeOption<RefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefumoipInfo> buildCheckerHook(DeciTreeOption<RefumoipInfo> option) {		
		List<ModelCheckerV1<RefumoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefumoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefumoipCheckRefund(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	//TODO: verificar refund duas vezes
	@Override protected List<ActionStdV1<RefumoipInfo>> buildActionsOnPassedHook(DeciTreeOption<RefumoipInfo> option) {
		List<ActionStdV1<RefumoipInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<RefumoipInfo> enforcePaypar = new StdRefumoipEnforcePaypar(option);	
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
