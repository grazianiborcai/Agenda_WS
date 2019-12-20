package br.com.mind5.business.personCustomer_.model.action;

import br.com.mind5.business.personCustomer_.info.PersonCusInfo;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiPersonCusEnforceEmail extends ActionVisitorTemplateEnforce<PersonCusInfo> {

	@Override protected PersonCusInfo enforceHook(PersonCusInfo recordInfo) {
		PersonCusInfo enforcedRecord = new PersonCusInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codEntityCateg = recordInfo.codEntityCateg;
		enforcedRecord.email = recordInfo.email;
		return enforcedRecord;
	}
}
