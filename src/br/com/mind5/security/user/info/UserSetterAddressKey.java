package br.com.mind5.security.user.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class UserSetterAddressKey extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		for (AddressInfo eachAddress : recordInfo.addresses) {
			eachAddress.codOwner = recordInfo.codOwner;
			eachAddress.codUser = recordInfo.codUser;
			eachAddress.username = recordInfo.username;
			eachAddress.lastChangedBy = recordInfo.lastChangedBy;	//TODO: remover
			eachAddress.codLanguage = recordInfo.codLanguage;
		}
		
		return recordInfo;
	}
}
