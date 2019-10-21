package br.com.mind5.payment.payOrderSearch.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;
import br.com.mind5.payment.payOrderSearch.model.decisionTree.RootPayordarchLatest;


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
