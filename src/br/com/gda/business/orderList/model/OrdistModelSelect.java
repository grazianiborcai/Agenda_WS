package br.com.gda.business.orderList.model;

import br.com.gda.business.orderList.info.OrdistInfo;
import br.com.gda.business.orderList.model.decisionTree.RootOrdistSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class OrdistModelSelect extends ModelTemplate<OrdistInfo> {

	public OrdistModelSelect(OrdistInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<OrdistInfo> getDecisionTreeHook(DeciTreeOption<OrdistInfo> option) {
		return new RootOrdistSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
