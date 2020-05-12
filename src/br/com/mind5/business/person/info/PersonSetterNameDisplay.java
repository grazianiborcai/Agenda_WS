package br.com.mind5.business.person.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PersonSetterNameDisplay extends InfoSetterTemplate<PersonInfo> {
	
	@Override protected PersonInfo setAttrHook(PersonInfo recordInfo) {
		recordInfo.nameDisplay = recordInfo.name;
		return recordInfo;
	}
}
