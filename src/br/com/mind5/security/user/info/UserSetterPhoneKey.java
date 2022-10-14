package br.com.mind5.security.user.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class UserSetterPhoneKey extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		for (PhoneInfo eachPhone : recordInfo.phones) {
			eachPhone.codOwner = recordInfo.codOwner;
			eachPhone.codUser = recordInfo.codUser;
			eachPhone.username = recordInfo.username;
			eachPhone.codLanguage = recordInfo.codLanguage;
			
			eachPhone.codLegalPerson = DefaultValue.number();
			eachPhone.codCustomer = DefaultValue.number();
			eachPhone.codStore = DefaultValue.number();
			eachPhone.codEmployee = DefaultValue.number();
			eachPhone.codOwnerRef = DefaultValue.number();
		}
		
		return recordInfo;
	}
}
