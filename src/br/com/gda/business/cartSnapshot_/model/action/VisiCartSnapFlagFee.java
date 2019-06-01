package br.com.gda.business.cartSnapshot_.model.action;


import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.business.masterData.info.common.CartFlag;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartSnapFlagFee extends ActionVisitorTemplateEnforce<CartSnapInfo> {
	
	@Override protected CartSnapInfo enforceHook(CartSnapInfo recordInfo) {
		recordInfo.recordFlag = CartFlag.FEE.getFlagId();
		return recordInfo;
	}
}
