package br.com.mind5.security.user.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class UserSetterPhoneKey extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		for (PhoneInfo eachAddress : recordInfo.phones) {
			eachAddress.codOwner = recordInfo.codOwner;
			eachAddress.codUser = recordInfo.codUser;
			eachAddress.username = recordInfo.username;
			eachAddress.codLanguage = recordInfo.codLanguage;
		}
		
		return recordInfo;
	}
}
