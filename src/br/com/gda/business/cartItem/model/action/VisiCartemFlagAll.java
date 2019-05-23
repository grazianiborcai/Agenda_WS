package br.com.gda.business.cartItem.model.action;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.masterData.info.common.CartFlag;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartemFlagAll extends ActionVisitorTemplateEnforce<CartemInfo> {
	
	@Override protected CartemInfo enforceHook(CartemInfo recordInfo) {
		recordInfo.recordFlag = CartFlag.ALL.getFlagId();
		return recordInfo;
	}
}
