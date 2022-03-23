package br.com.mind5.business.cart.model;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.decisionTree.CartRootDelete;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartModelDelete extends ModelTemplate<CartInfo> {

	public CartModelDelete(CartInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CartInfo> getDecisionTreeHook(DeciTreeOption<CartInfo> option) {
		return new CartRootDelete(option);
	}
}
