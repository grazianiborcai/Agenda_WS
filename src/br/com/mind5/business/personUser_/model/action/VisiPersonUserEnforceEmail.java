package br.com.mind5.business.personUser_.model.action;

import br.com.mind5.business.personUser_.info.PersonUserInfo;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiPersonUserEnforceEmail extends ActionVisitorTemplateEnforce<PersonUserInfo> {

	@Override protected PersonUserInfo enforceHook(PersonUserInfo recordInfo) {
		PersonUserInfo enforcedRecord = new PersonUserInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codEntityCateg = recordInfo.codEntityCateg;
		enforcedRecord.email = recordInfo.email;
		return enforcedRecord;
	}
}
