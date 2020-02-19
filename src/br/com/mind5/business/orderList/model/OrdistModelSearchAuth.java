package br.com.mind5.business.orderList.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.decisionTree.RootOrdistSearchAuth;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdistModelSearchAuth extends ModelTemplate<OrdistInfo> {

	public OrdistModelSearchAuth(String incomingData, HttpServletRequest request) {
		super(incomingData, request, OrdistInfo.class);
	}
	
	
	
	@Override protected DeciTree<OrdistInfo> getDecisionTreeHook(DeciTreeOption<OrdistInfo> option) {
		return new RootOrdistSearchAuth(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
