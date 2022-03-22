package br.com.mind5.business.addressDefault.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class AddaultSetterCustomerKey extends InfoSetterTemplate<AddaultInfo> {
	
	@Override protected AddaultInfo setAttrHook(AddaultInfo recordInfo) {
		AddaultInfo result = new AddaultInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codCustomer = recordInfo.codCustomer;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}
}
