package br.com.gda.business.cart.model.action;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartSetterLChanged;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartEnforceLChanged extends ActionVisitorTemplateEnforce<CartInfo> {
	
	@Override protected CartInfo enforceHook(CartInfo recordInfo) {
		CartSetterLChanged setter = new CartSetterLChanged();
		return setter.setAttr(recordInfo);
	}
}
