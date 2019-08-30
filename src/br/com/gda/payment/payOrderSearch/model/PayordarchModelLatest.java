package br.com.gda.payment.payOrderSearch.model;

import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrderSearch.info.PayordarchInfo;
import br.com.gda.payment.payOrderSearch.model.decisionTree.RootPayordarchLatest;


public final class PayordarchModelLatest extends ModelTemplate<PayordarchInfo> {

	public PayordarchModelLatest(PayordarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<PayordarchInfo> getDecisionTreeHook(DeciTreeOption<PayordarchInfo> option) {
		return new RootPayordarchLatest(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
