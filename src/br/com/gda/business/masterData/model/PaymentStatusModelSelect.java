package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.PaymentStatusInfo;
import br.com.gda.business.masterData.model.decisionTree.RootPaymentStatusSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PaymentStatusModelSelect extends ModelTemplate<PaymentStatusInfo> {

	public PaymentStatusModelSelect(PaymentStatusInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<PaymentStatusInfo> getDecisionTreeHook(DeciTreeOption<PaymentStatusInfo> option) {
		return new RootPaymentStatusSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
