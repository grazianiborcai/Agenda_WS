package br.com.mind5.business.cartItem.model.action;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.info.CartemSetterKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiCartemEnforceKey extends ActionVisitorTemplateEnforce<CartemInfo> {
	
	@Override protected CartemInfo enforceHook(CartemInfo recordInfo) {
		InfoSetter<CartemInfo> setter = new CartemSetterKey();
		return setter.setAttr(recordInfo);
	}
}
