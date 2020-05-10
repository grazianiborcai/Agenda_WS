package br.com.mind5.payment.refundOrderItem.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.model.decisionTree.RootRefemRefundAuth;


public final class RefemModelRefundAuth extends ModelTemplate<RefemInfo> {
	
	public RefemModelRefundAuth(RefemInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<RefemInfo> getDecisionTreeHook(DeciTreeOption<RefemInfo> option) {
		return new RootRefemRefundAuth(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}	
}
