package br.com.gda.business.cartItem.model.action;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.info.CartemSetterCreatedOn;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartemEnforceCreatedOn extends ActionVisitorTemplateEnforce<CartemInfo> {
	
	@Override protected CartemInfo enforceHook(CartemInfo recordInfo) {
		CartemSetterCreatedOn setter = new CartemSetterCreatedOn();
		return setter.setAttr(recordInfo);
	}
}
