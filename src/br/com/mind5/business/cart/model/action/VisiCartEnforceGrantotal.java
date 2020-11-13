package br.com.mind5.business.cart.model.action;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.info.CartSetterGrantotal;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartEnforceGrantotal extends ActionVisitorTemplateEnforce<CartInfo> {
	
	public VisiCartEnforceGrantotal(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CartInfo enforceHook(CartInfo recordInfo) {
		InfoSetter<CartInfo> setter = new CartSetterGrantotal();
		return setter.setAttr(recordInfo);
	}
}
