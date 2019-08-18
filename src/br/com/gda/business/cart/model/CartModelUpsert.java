package br.com.gda.business.cart.model;

import javax.servlet.http.HttpServletRequest;
import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.decisionTree.RootCartUpsert;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CartModelUpsert extends ModelTemplate<CartInfo> {

	public CartModelUpsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, CartInfo.class);
	}
	
	
	
	@Override protected DeciTree<CartInfo> getDecisionTreeHook(DeciTreeOption<CartInfo> option) {
		return new RootCartUpsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
