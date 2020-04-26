package br.com.mind5.business.cart.model.action;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.info.CartSetterCurrency;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartEnforceCurrency extends ActionVisitorTemplateEnforceV2<CartInfo> {
	
	public VisiCartEnforceCurrency(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CartInfo enforceHook(CartInfo recordInfo) {
		InfoSetter<CartInfo> setter = new CartSetterCurrency();
		return setter.setAttr(recordInfo);
	}
}
