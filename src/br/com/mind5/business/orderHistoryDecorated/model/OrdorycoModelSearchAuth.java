package br.com.mind5.business.orderHistoryDecorated.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.orderHistoryDecorated.info.OrdorycoInfo;
import br.com.mind5.business.orderHistoryDecorated.model.decisionTree.RootOrdorycoSearchAuth;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdorycoModelSearchAuth extends ModelTemplate<OrdorycoInfo> {

	public OrdorycoModelSearchAuth(String incomingData, HttpServletRequest request) {
		super(incomingData, request, OrdorycoInfo.class);
	}
	
	
	
	@Override protected DeciTree<OrdorycoInfo> getDecisionTreeHook(DeciTreeOption<OrdorycoInfo> option) {
		return new RootOrdorycoSearchAuth(option);
	}
}
