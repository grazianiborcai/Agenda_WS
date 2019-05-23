package br.com.gda.business.cartItem.model.action;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.info.CartemSetterLChanged;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartemEnforceLChanged extends ActionVisitorTemplateEnforce<CartemInfo> {
	
	@Override protected CartemInfo enforceHook(CartemInfo recordInfo) {
		CartemSetterLChanged setter = new CartemSetterLChanged();
		return setter.setAttr(recordInfo);
	}
}
