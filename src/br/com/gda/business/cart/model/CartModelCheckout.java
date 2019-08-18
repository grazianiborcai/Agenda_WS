package br.com.gda.business.cart.model;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.decisionTree.RootCartCheckout;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CartModelCheckout extends ModelTemplate<CartInfo> {

	public CartModelCheckout(CartInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CartInfo> getDecisionTreeHook(DeciTreeOption<CartInfo> option) {
		return new RootCartCheckout(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
