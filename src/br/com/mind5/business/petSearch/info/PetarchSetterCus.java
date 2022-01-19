package br.com.mind5.business.petSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PetarchSetterCus extends InfoSetterTemplate<PetarchInfo> {
	
	@Override protected PetarchInfo setAttrHook(PetarchInfo recordInfo) {
		PetarchInfo result = new PetarchInfo();		

		result.codOwner = recordInfo.codOwner;
		result.codCustomer = recordInfo.codCustomer;	
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}	
}
