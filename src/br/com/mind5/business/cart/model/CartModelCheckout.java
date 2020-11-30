package br.com.mind5.business.cart.model;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.decisionTree.RootCartCheckout;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartModelCheckout extends ModelTemplate<CartInfo> {

	public CartModelCheckout(CartInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CartInfo> getDecisionTreeHook(DeciTreeOption<CartInfo> option) {
		return new RootCartCheckout(option);
	}
}
