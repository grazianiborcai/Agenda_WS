package br.com.mind5.business.cart.model.action;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.info.CartSetterCurrency;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartVisiEnforceCurrency extends ActionVisitorTemplateEnforce<CartInfo> {
	
	public CartVisiEnforceCurrency(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CartInfo enforceHook(CartInfo recordInfo) {
		InfoSetter<CartInfo> setter = new CartSetterCurrency();
		return setter.setAttr(recordInfo);
	}
}
