package br.com.mind5.business.addressDefault.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class AddaultSetterUserKey extends InfoSetterTemplate<AddaultInfo> {
	
	@Override protected AddaultInfo setAttrHook(AddaultInfo recordInfo) {
		AddaultInfo result = new AddaultInfo();
		
		result.codUser     = recordInfo.codUser;
		result.codOwner    = recordInfo.codOwner;		
		result.username    = recordInfo.username;		
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}
}
