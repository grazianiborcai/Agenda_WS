package br.com.mind5.business.cart.model.action;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.info.CartSetterExpiryOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartEnforceExpiryOn extends ActionVisitorTemplateEnforce<CartInfo> {
	
	public VisiCartEnforceExpiryOn(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CartInfo enforceHook(CartInfo recordInfo) {
		InfoSetter<CartInfo> setter = new CartSetterExpiryOn();
		return setter.setAttr(recordInfo);
	}
}
