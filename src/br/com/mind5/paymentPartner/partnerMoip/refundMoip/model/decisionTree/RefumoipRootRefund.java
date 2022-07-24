package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.RefumoipVisiNodeRefundL1;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.RefumoipVisiEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.RefumoipVisiEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.RefumoipVisiMergePayordemist;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.RefumoipVisiRefund;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.checker.RefumoipCheckRefund;

public final class RefumoipRootRefund extends DeciTreeTemplateWrite<RefumoipInfo> {
	
	public RefumoipRootRefund(DeciTreeOption<RefumoipInfo> option) {
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
		
		ActionStd<RefumoipInfo> enforcePaypar = new ActionStdCommom<RefumoipInfo>(option, RefumoipVisiEnforcePaypar.class);	
		ActionLazy<RefumoipInfo> mergePayordemist = new ActionLazyCommom<RefumoipInfo>(option, RefumoipVisiMergePayordemist.class);	
		ActionLazy<RefumoipInfo> nodeRefund = new ActionLazyCommom<RefumoipInfo>(option, RefumoipVisiNodeRefundL1.class);		
		ActionLazy<RefumoipInfo> refund = new ActionLazyCommom<RefumoipInfo>(option, RefumoipVisiRefund.class);
		ActionLazy<RefumoipInfo> enforceResponseAttr = new ActionLazyCommom<RefumoipInfo>(option, RefumoipVisiEnforceResponseAttr.class);
		
		enforcePaypar.addPostAction(mergePayordemist);
		mergePayordemist.addPostAction(nodeRefund);
		nodeRefund.addPostAction(refund);
		refund.addPostAction(enforceResponseAttr);
		
		actions.add(enforcePaypar);		
		return actions;
	}
}
