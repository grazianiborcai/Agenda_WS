package br.com.gda.business.cartItem.model.action;

import br.com.gda.business.cartItem.info.CartInfo;
import br.com.gda.business.masterData.info.common.CartCateg;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartEnforceItmCategItem extends ActionVisitorTemplateEnforce<CartInfo> {
	
	@Override protected CartInfo enforceHook(CartInfo recordInfo) {
		recordInfo.codItemCateg = CartCateg.ITEM.getCodCateg();
		return recordInfo;
	}
}
