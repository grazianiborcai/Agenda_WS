package br.com.mind5.business.cartReserve.model.action;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.info.CarterveSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiCarterveEnforceLChanged extends ActionVisitorTemplateEnforce<CarterveInfo> {
	
	@Override protected CarterveInfo enforceHook(CarterveInfo recordInfo) {
		InfoSetter<CarterveInfo> setter = new CarterveSetterLChanged();
		return setter.setAttr(recordInfo);
	}
}
