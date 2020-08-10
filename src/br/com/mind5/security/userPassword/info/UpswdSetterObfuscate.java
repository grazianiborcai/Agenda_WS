package br.com.mind5.security.userPassword.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class UpswdSetterObfuscate extends InfoSetterTemplate<UpswdInfo> {
	
	@Override protected UpswdInfo setAttrHook(UpswdInfo recordInfo) {
		UpswdInfo result = new UpswdInfo();		
		
		result.codOwner = recordInfo.codOwner;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}
}
