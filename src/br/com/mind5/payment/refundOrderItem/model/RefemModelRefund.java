package br.com.mind5.payment.refundOrderItem.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.model.decisionTree.RootRefemRefund;


public final class RefemModelRefund extends ModelTemplate<RefemInfo> {
	
	public RefemModelRefund(RefemInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<RefemInfo> getDecisionTreeHook(DeciTreeOption<RefemInfo> option) {
		return new RootRefemRefund(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}	
}
