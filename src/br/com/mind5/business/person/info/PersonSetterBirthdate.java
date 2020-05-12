package br.com.mind5.business.person.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PersonSetterBirthdate extends InfoSetterTemplate<PersonInfo> {
	
	@Override protected PersonInfo setAttrHook(PersonInfo recordInfo) {
		if (recordInfo.birthDate == null)
			return recordInfo;
		
		
		recordInfo.birthYear = recordInfo.birthDate.getYear();
		recordInfo.birthMonth = recordInfo.birthDate.getMonthValue();
		recordInfo.birthDay = recordInfo.birthDate.getDayOfMonth();
		
		return recordInfo;
	}
}
