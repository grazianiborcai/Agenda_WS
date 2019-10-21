package br.com.mind5.business.cart.model.action;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.info.CartSetterGrantotal;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiCartEnforceGrantotal extends ActionVisitorTemplateEnforce<CartInfo> {
	
	@Override protected CartInfo enforceHook(CartInfo recordInfo) {
		InfoSetter<CartInfo> setter = new CartSetterGrantotal();
		return setter.setAttr(recordInfo);
	}
}
