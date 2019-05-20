package br.com.gda.business.userSnapshot_.model.action;

import br.com.gda.business.userSnapshot_.info.UserSnapInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiUserSnapEnforceKey extends ActionVisitorTemplateEnforce<UserSnapInfo> {
	@Override protected UserSnapInfo enforceHook(UserSnapInfo recordInfo) {
		UserSnapInfo enforcedRecord = new UserSnapInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codSnapshot = recordInfo.codSnapshot;
		return enforcedRecord;
	}
}
