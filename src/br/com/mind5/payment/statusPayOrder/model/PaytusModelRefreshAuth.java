package br.com.mind5.payment.statusPayOrder.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.decisionTree.PaytusRootRefreshAuth;

public final class PaytusModelRefreshAuth extends ModelTemplate<PaytusInfo> {
	
	public PaytusModelRefreshAuth(PaytusInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<PaytusInfo> getDecisionTreeHook(DeciTreeOption<PaytusInfo> option) {
		return new PaytusRootRefreshAuth(option);
	}
}
