package br.com.mind5.business.cart.model.action;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.info.CartSetterCartemKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiCartEnforceCartemKey extends ActionVisitorTemplateEnforce<CartInfo> {
	
	@Override protected CartInfo enforceHook(CartInfo recordInfo) {
		InfoSetter<CartInfo> setter = new CartSetterCartemKey();
		return setter.setAttr(recordInfo);
	}
}
