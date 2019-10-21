package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.PaymentStatusInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootPaymentStatusSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
