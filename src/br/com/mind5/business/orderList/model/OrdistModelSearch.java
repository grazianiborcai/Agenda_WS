package br.com.mind5.business.orderList.model;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.decisionTree.RootOrdistSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdistModelSearch extends ModelTemplate<OrdistInfo> {

	public OrdistModelSearch(OrdistInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<OrdistInfo> getDecisionTreeHook(DeciTreeOption<OrdistInfo> option) {
		return new RootOrdistSearch(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
