package br.com.gda.business.cart.model.action;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartEnforceWeekday extends ActionVisitorTemplateEnforce<CartInfo> {
	
	@Override protected CartInfo enforceHook(CartInfo recordInfo) {
		recordInfo.codWeekday = recordInfo.date.getDayOfWeek().getValue();
		return recordInfo;
	}
}
