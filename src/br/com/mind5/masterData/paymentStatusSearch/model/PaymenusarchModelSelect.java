package br.com.mind5.masterData.paymentStatusSearch.model;

import br.com.mind5.masterData.paymentStatusSearch.info.PaymenusarchInfo;
import br.com.mind5.masterData.paymentStatusSearch.model.decisionTree.RootPaymenusarchSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PaymenusarchModelSelect extends ModelTemplate<PaymenusarchInfo> {

	public PaymenusarchModelSelect(PaymenusarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<PaymenusarchInfo> getDecisionTreeHook(DeciTreeOption<PaymenusarchInfo> option) {
		return new RootPaymenusarchSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
