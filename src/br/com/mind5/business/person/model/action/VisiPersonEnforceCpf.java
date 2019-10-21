package br.com.mind5.business.person.model.action;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiPersonEnforceCpf extends ActionVisitorTemplateEnforce<PersonInfo> {
	
	@Override protected PersonInfo enforceHook(PersonInfo recordInfo) {
		PersonInfo enforcedRecord = new PersonInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.cpf = recordInfo.cpf;
		enforcedRecord.codEntityCateg = recordInfo.codEntityCateg;
		return enforcedRecord;
	}
}
