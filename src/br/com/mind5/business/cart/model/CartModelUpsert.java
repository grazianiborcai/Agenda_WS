package br.com.mind5.business.cart.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.decisionTree.CartRootUpsert;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartModelUpsert extends ModelTemplate<CartInfo> {

	public CartModelUpsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, CartInfo.class);
	}
	
	
	
	@Override protected DeciTree<CartInfo> getDecisionTreeHook(DeciTreeOption<CartInfo> option) {
		return new CartRootUpsert(option);
	}
}
