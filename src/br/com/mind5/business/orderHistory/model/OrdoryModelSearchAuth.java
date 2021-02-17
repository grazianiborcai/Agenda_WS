package br.com.mind5.business.orderHistory.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.orderHistory.info.OrdoryInfo;
import br.com.mind5.business.orderHistory.model.decisionTree.RootOrdorySearchAuth;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdoryModelSearchAuth extends ModelTemplate<OrdoryInfo> {

	public OrdoryModelSearchAuth(String incomingData, HttpServletRequest request) {
		super(incomingData, request, OrdoryInfo.class);
	}
	
	
	
	@Override protected DeciTree<OrdoryInfo> getDecisionTreeHook(DeciTreeOption<OrdoryInfo> option) {
		return new RootOrdorySearchAuth(option);
	}
}
