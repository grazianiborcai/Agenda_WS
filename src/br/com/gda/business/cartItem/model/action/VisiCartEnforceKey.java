package br.com.gda.business.cartItem.model.action;

import br.com.gda.business.cartItem.info.CartInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartEnforceKey extends ActionVisitorTemplateEnforce<CartInfo> {
	
	@Override protected CartInfo enforceHook(CartInfo recordInfo) {
		CartInfo enforcedRecord = new CartInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codUser = recordInfo.codUser;
		return enforcedRecord;
	}
}
