package br.com.gda.business.personCustomer.model.action;

import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiPersonCusEnforceEmail extends ActionVisitorTemplateEnforce<PersonCusInfo> {

	@Override protected PersonCusInfo enforceHook(PersonCusInfo recordInfo) {
		PersonCusInfo enforcedRecord = new PersonCusInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codEntityCateg = recordInfo.codEntityCateg;
		enforcedRecord.email = recordInfo.email;
		return enforcedRecord;
	}
}
