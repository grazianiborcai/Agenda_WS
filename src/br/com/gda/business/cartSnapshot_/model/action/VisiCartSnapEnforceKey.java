package br.com.gda.business.cartSnapshot_.model.action;

import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCartSnapEnforceKey extends ActionVisitorTemplateEnforce<CartSnapInfo> {
	@Override protected CartSnapInfo enforceHook(CartSnapInfo recordInfo) {
		CartSnapInfo enforcedRecord = new CartSnapInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codSnapshot = recordInfo.codSnapshot;
		return enforcedRecord;
	}
}
