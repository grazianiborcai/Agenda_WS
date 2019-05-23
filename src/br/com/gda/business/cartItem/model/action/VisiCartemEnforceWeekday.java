package br.com.gda.business.cartItem.model.action;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartemEnforceWeekday extends ActionVisitorTemplateEnforce<CartemInfo> {
	
	@Override protected CartemInfo enforceHook(CartemInfo recordInfo) {
		recordInfo.codWeekday = recordInfo.date.getDayOfWeek().getValue();
		return recordInfo;
	}
}
