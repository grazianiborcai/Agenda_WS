package br.com.gda.business.cart.model.action;

import br.com.gda.business.cart.info.CartFlag;
import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartFlagAll extends ActionVisitorTemplateEnforce<CartInfo> {
	
	@Override protected CartInfo enforceHook(CartInfo recordInfo) {
		recordInfo.recordFlag = CartFlag.ALL.getFlagId();
		return recordInfo;
	}
}
