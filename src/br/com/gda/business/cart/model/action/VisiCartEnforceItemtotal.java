package br.com.gda.business.cart.model.action;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartSetterItemtotal;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartEnforceItemtotal extends ActionVisitorTemplateEnforce<CartInfo> {
	
	@Override protected CartInfo enforceHook(CartInfo recordInfo) {
		InfoSetter<CartInfo> setter = new CartSetterItemtotal();
		return setter.setAttr(recordInfo);
	}
}
