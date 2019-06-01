package br.com.gda.business.cartSnapshot_.model.action;

import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartSnapEnforceWeekday extends ActionVisitorTemplateEnforce<CartSnapInfo> {
	
	@Override protected CartSnapInfo enforceHook(CartSnapInfo recordInfo) {
		recordInfo.codWeekday = recordInfo.date.getDayOfWeek().getValue();
		return recordInfo;
	}
}
