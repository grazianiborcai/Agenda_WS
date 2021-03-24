package br.com.mind5.file.fileImageSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class FimarchSetterGroup extends InfoSetterTemplate<FimarchInfo> {
	
	@Override protected FimarchInfo setAttrHook(FimarchInfo recordInfo) {
		FimarchInfo result = new FimarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codGroup = recordInfo.codGroup; 
		result.codLanguage = recordInfo.codLanguage; 
		result.username = recordInfo.username; 
		
		return result;
	}
}
