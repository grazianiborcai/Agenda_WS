package br.com.gda.business.personUser.model.action;

import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiPersonUserEnforceCpf extends ActionVisitorTemplateEnforce<PersonUserInfo> {

	@Override protected PersonUserInfo enforceHook(PersonUserInfo recordInfo) {
		PersonUserInfo enforcedRecord = new PersonUserInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codEntityCateg = recordInfo.codEntityCateg;
		enforcedRecord.cpf = recordInfo.cpf;
		return enforcedRecord;
	}
}
