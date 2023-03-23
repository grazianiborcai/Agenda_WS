package br.com.mind5.business.addressSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class AddarchSetterUserAddressKey extends InfoSetterTemplate<AddarchInfo> {
	
	@Override protected AddarchInfo setAttrHook(AddarchInfo recordInfo) {
		AddarchInfo result = new AddarchInfo();
		
		result.codUser     = recordInfo.codUser;
		result.codOwner    = recordInfo.codOwner;		
		result.username    = recordInfo.username;
		result.codAddress  = recordInfo.codAddress;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}
}
