package br.com.mind5.business.person.info;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class PersonSetterPerbioKey extends InfoSetterTemplate<PersonInfo> {
	
	@Override protected PersonInfo setAttrHook(PersonInfo recordInfo) {
		for (PerbioInfo eachPerbio : recordInfo.perbios) {
			eachPerbio.codOwner = recordInfo.codOwner;
			eachPerbio.codPerson = recordInfo.codPerson;
			eachPerbio.username = recordInfo.username;
			
			if (eachPerbio.codLanguage == null)
				eachPerbio.codLanguage = recordInfo.codLanguage;			
		}

		
		return recordInfo;
	}
}
