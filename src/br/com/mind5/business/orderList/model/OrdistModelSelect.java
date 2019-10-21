package br.com.mind5.business.orderList.model;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.decisionTree.RootOrdistSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
