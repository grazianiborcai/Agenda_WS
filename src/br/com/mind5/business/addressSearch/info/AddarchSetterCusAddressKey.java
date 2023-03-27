package br.com.mind5.business.addressSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class AddarchSetterCusAddressKey extends InfoSetterTemplate<AddarchInfo> {
	
	@Override protected AddarchInfo setAttrHook(AddarchInfo recordInfo) {
		AddarchInfo result = new AddarchInfo();		
		
		result.codOwner    = recordInfo.codOwner;		
		result.username    = recordInfo.username;
		result.codAddress  = recordInfo.codAddress;
		result.codCustomer = recordInfo.codCustomer;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}
}
