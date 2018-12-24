package br.com.gda.business.cartSnapshot.model.action;


import br.com.gda.business.cart.info.CartFlag;
import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartSnapFlagItem extends ActionVisitorTemplateEnforce<CartSnapInfo> {
	
	@Override protected CartSnapInfo enforceHook(CartSnapInfo recordInfo) {
		recordInfo.recordFlag = CartFlag.ITEM.getFlagId();
		return recordInfo;
	}
}
