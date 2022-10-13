package br.com.mind5.security.user.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class UserSetterAddressKey extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		for (AddressInfo eachAddress : recordInfo.addresses) {
			eachAddress.codOwner = recordInfo.codOwner;
			eachAddress.codUser = recordInfo.codUser;
			eachAddress.username = recordInfo.username;
			eachAddress.codLanguage = recordInfo.codLanguage;
			
			eachAddress.codLegalPerson = DefaultValue.number();
			eachAddress.codCustomer = DefaultValue.number();
			eachAddress.codStore = DefaultValue.number();
			eachAddress.codEmployee = DefaultValue.number();
			eachAddress.codOwnerRef = DefaultValue.number();
		}
		
		return recordInfo;
	}
}
