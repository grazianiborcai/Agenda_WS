package br.com.mind5.security.userSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class UserarchSetterAuth extends InfoSetterTemplate<UserarchInfo> {
	
	@Override protected UserarchInfo setAttrHook(UserarchInfo recordInfo) {
		UserarchInfo result = new UserarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		result.codAuthGroup = recordInfo.codAuthGroup;
				
		return result;
	}
}
