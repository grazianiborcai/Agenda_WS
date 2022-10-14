package br.com.mind5.business.person.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.Gender;

public final class PersonSetterGenderDefault extends InfoSetterTemplate<PersonInfo> {
	
	@Override protected PersonInfo setAttrHook(PersonInfo recordInfo) {
		recordInfo.codGender = Gender.DEFAULT.getCodGender();
		return recordInfo;
	}
}
