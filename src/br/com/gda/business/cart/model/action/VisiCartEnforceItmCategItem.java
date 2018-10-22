package br.com.gda.business.cart.model.action;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.masterData.info.CartCateg;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartEnforceItmCategItem extends ActionVisitorTemplateEnforce<CartInfo> {
	
	@Override protected CartInfo enforceHook(CartInfo recordInfo) {
		recordInfo.codItemCateg = CartCateg.ITEM.getCodCateg();
		return recordInfo;
	}
}
