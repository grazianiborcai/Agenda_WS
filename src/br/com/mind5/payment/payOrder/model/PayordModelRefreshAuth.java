package br.com.mind5.payment.payOrder.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.decisionTree.PayordRootRefreshAuth;

public final class PayordModelRefreshAuth extends ModelTemplate<PayordInfo> {
	
	public PayordModelRefreshAuth(PayordInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<PayordInfo> getDecisionTreeHook(DeciTreeOption<PayordInfo> option) {
		return new PayordRootRefreshAuth(option);
	}
}
