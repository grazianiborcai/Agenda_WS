package br.com.gda.business.cartItem.model.action;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.info.CartemSetterTotitem;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartemEnforceTotitem extends ActionVisitorTemplateEnforce<CartemInfo> {
	
	@Override protected CartemInfo enforceHook(CartemInfo recordInfo) {
		InfoSetter<CartemInfo> setter = new CartemSetterTotitem();
		return setter.setAttr(recordInfo);
	}
}
