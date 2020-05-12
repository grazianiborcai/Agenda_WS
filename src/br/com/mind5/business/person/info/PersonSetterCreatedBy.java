package br.com.mind5.business.person.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PersonSetterCreatedBy extends InfoSetterTemplate<PersonInfo> {
	
	@Override protected PersonInfo setAttrHook(PersonInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
