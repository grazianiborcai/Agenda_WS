package br.com.gda.business.cartItem.model.action;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.masterData.info.common.CartCateg;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartemEnforceItmCategItem extends ActionVisitorTemplateEnforce<CartemInfo> {
	
	@Override protected CartemInfo enforceHook(CartemInfo recordInfo) {
		recordInfo.codItemCateg = CartCateg.ITEM.getCodCateg();
		return recordInfo;
	}
}
