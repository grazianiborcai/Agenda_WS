package br.com.gda.payment.storePartnerList.model;

import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.storePartnerList.info.StoplisInfo;
import br.com.gda.payment.storePartnerList.model.decisionTree.RootStoplisSelect;

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
