package br.com.mind5.payment.statusPayOrder.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.decisionTree.RootPaytusRefresh;

public final class PaytusModelRefresh extends ModelTemplate<PaytusInfo> {
	
	public PaytusModelRefresh(PaytusInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<PaytusInfo> getDecisionTreeHook(DeciTreeOption<PaytusInfo> option) {
		return new RootPaytusRefresh(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
