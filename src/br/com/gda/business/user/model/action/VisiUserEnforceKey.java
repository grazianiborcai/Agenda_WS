package br.com.gda.business.user.model.action;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiUserEnforceKey extends ActionVisitorTemplateEnforce<UserInfo> {
	@Override protected UserInfo enforceHook(UserInfo recordInfo) {
		UserInfo enforcedRecord = new UserInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codUser = recordInfo.codUser;
		return enforcedRecord;
	}
}
