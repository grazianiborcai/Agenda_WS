package br.com.mind5.payment.storePartnerList.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.model.decisionTree.RootStoplisSelect;

public final class StoplisModelSelect extends ModelTemplate<StoplisInfo> {

	public StoplisModelSelect(StoplisInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StoplisInfo> getDecisionTreeHook(DeciTreeOption<StoplisInfo> option) {
		return new RootStoplisSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
