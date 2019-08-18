package br.com.gda.business.cart.model;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.decisionTree.RootCartDelete;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CartModelDelete extends ModelTemplate<CartInfo> {

	public CartModelDelete(CartInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CartInfo> getDecisionTreeHook(DeciTreeOption<CartInfo> option) {
		return new RootCartDelete(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
