package br.com.mind5.business.orderList.model;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.decisionTree.RootOrdistSearchAuth;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdistModelSearchAuth extends ModelTemplate<OrdistInfo> {

	public OrdistModelSearchAuth(OrdistInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<OrdistInfo> getDecisionTreeHook(DeciTreeOption<OrdistInfo> option) {
		return new RootOrdistSearchAuth(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
