package br.com.mind5.business.personSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PerarchSetterReadEmail extends InfoSetterTemplate<PerarchInfo> {
	
	@Override protected PerarchInfo setAttrHook(PerarchInfo recordInfo) {
		PerarchInfo result = new PerarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codEntityCateg = recordInfo.codEntityCateg;
		result.email = recordInfo.email;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}	
}
