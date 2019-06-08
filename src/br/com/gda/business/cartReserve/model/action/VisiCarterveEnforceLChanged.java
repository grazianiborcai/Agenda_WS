package br.com.gda.business.cartReserve.model.action;

import br.com.gda.business.cartReserve.info.CarterveInfo;
import br.com.gda.business.cartReserve.info.CarterveSetterLChanged;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCarterveEnforceLChanged extends ActionVisitorTemplateEnforce<CarterveInfo> {
	
	@Override protected CarterveInfo enforceHook(CarterveInfo recordInfo) {
		InfoSetter<CarterveInfo> setter = new CarterveSetterLChanged();
		return setter.setAttr(recordInfo);
	}
}
