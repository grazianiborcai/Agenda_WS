package br.com.gda.business.cart.model;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.decisionTree.RootCartSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CartModelSelect extends ModelTemplate<CartInfo> {

	public CartModelSelect(CartInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CartInfo> getDecisionTreeHook(DeciTreeOption<CartInfo> option) {
		return new RootCartSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
