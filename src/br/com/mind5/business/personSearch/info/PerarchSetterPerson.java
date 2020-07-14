package br.com.mind5.business.personSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PerarchSetterPerson extends InfoSetterTemplate<PerarchInfo> {
	
	@Override protected PerarchInfo setAttrHook(PerarchInfo recordInfo) {
		PerarchInfo result = new PerarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codPerson = recordInfo.codPerson;
		result.codEntityCateg = recordInfo.codEntityCateg;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}	
}
