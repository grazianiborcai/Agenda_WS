package br.com.mind5.payment.payOrder.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.decisionTree.PayordRootPay;


public final class PayordModelPay extends ModelTemplate<PayordInfo> {

	public PayordModelPay(String incomingData, HttpServletRequest request) {
		super(incomingData, request, PayordInfo.class);
	}
	
	
	
	@Override protected DeciTree<PayordInfo> getDecisionTreeHook(DeciTreeOption<PayordInfo> option) {
		return new PayordRootPay(option);
	}
}
