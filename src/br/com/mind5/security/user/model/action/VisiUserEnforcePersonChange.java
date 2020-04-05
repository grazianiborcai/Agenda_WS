package br.com.mind5.security.user.model.action;

import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;
import br.com.mind5.security.user.info.UserInfo;

final class VisiUserEnforcePersonChange extends ActionVisitorTemplateEnforceV1<UserInfo> {
	
	@Override protected UserInfo enforceHook(UserInfo recordInfo) {
		UserInfo enforcedRecord = new UserInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codUser = recordInfo.codUser;
		enforcedRecord.codPerson = recordInfo.codPerson;
		return enforcedRecord;
	}
}
