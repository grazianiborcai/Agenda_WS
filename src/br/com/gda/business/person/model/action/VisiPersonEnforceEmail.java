package br.com.gda.business.person.model.action;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiPersonEnforceEmail extends ActionVisitorTemplateEnforce<PersonInfo> {
	
	@Override protected PersonInfo enforceHook(PersonInfo recordInfo) {
		PersonInfo enforcedRecord = new PersonInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.email = recordInfo. email;
		return enforcedRecord;
	}
}
