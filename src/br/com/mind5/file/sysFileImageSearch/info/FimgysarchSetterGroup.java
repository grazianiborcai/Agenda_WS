package br.com.mind5.file.sysFileImageSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class FimgysarchSetterGroup extends InfoSetterTemplate<FimgysarchInfo> {
	
	@Override protected FimgysarchInfo setAttrHook(FimgysarchInfo recordInfo) {
		FimgysarchInfo result = new FimgysarchInfo();
		
		result.codGroup = recordInfo.codGroup; 
		result.codLanguage = recordInfo.codLanguage; 
		result.username = recordInfo.username; 
		
		return result;
	}
}
