package br.com.mind5.business.cartItem.model.action;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.info.CartemSetterWeekday;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiCartemEnforceWeekday extends ActionVisitorTemplateEnforce<CartemInfo> {
	
	@Override protected CartemInfo enforceHook(CartemInfo recordInfo) {
		InfoSetter<CartemInfo> setter = new CartemSetterWeekday();
		return setter.setAttr(recordInfo);
	}
}
