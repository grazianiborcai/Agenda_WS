package br.com.gda.business.cartItem.model.action;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartemEnforceKey extends ActionVisitorTemplateEnforce<CartemInfo> {
	
	@Override protected CartemInfo enforceHook(CartemInfo recordInfo) {
		CartemInfo enforcedRecord = new CartemInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codUser = recordInfo.codUser;
		return enforcedRecord;
	}
}
