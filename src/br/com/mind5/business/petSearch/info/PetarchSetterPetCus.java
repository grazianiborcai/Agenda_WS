package br.com.mind5.business.petSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PetarchSetterPetCus extends InfoSetterTemplate<PetarchInfo> {
	
	@Override protected PetarchInfo setAttrHook(PetarchInfo recordInfo) {
		PetarchInfo result = new PetarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codCustomer = recordInfo.codCustomer;
		result.codPet = recordInfo.codPet;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}
}
