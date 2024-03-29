package br.com.mind5.payment.refundOrder.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrder.model.decisionTree.RefuRootRefund;


public final class RefuModelRefund extends ModelTemplate<RefuInfo> {
	
	public RefuModelRefund(RefuInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<RefuInfo> getDecisionTreeHook(DeciTreeOption<RefuInfo> option) {
		return new RefuRootRefund(option);
	}
}
