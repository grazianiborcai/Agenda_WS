package br.com.mind5.business.addressSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class AddarchSetterPeregKey extends InfoSetterTemplate<AddarchInfo> {
	
	@Override protected AddarchInfo setAttrHook(AddarchInfo recordInfo) {
		AddarchInfo result = new AddarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codLegalPerson = recordInfo.codLegalPerson; 
		result.codLanguage = recordInfo.codLanguage; 
		result.username = recordInfo.username; 
		
		return result;
	}
}
