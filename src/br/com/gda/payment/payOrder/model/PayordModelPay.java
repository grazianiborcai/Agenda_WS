package br.com.gda.payment.payOrder.model;

import javax.servlet.http.HttpServletRequest;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.model.decisionTree.RootPayordPay;


public final class PayordModelPay extends ModelTemplate<PayordInfo> {

	public PayordModelPay(String incomingData, HttpServletRequest request) {
		super(incomingData, request, PayordInfo.class);
	}
	
	
	
	@Override protected DeciTree<PayordInfo> getDecisionTreeHook(DeciTreeOption<PayordInfo> option) {
		return new RootPayordPay(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
