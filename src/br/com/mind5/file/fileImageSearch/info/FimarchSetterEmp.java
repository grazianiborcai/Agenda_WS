package br.com.mind5.file.fileImageSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class FimarchSetterEmp extends InfoSetterTemplate<FimarchInfo> {
	
	@Override protected FimarchInfo setAttrHook(FimarchInfo recordInfo) {
		FimarchInfo result = new FimarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codEmployee = recordInfo.codEmployee; 
		result.codLanguage = recordInfo.codLanguage; 
		result.username = recordInfo.username; 
		
		return result;
	}
}
