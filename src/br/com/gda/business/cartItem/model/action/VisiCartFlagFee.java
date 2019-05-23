package br.com.gda.business.cartItem.model.action;

import br.com.gda.business.cartItem.info.CartInfo;
import br.com.gda.business.masterData.info.common.CartFlag;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartFlagFee extends ActionVisitorTemplateEnforce<CartInfo> {
	
	@Override protected CartInfo enforceHook(CartInfo recordInfo) {
		recordInfo.recordFlag = CartFlag.FEE.getFlagId();
		return recordInfo;
	}
}
