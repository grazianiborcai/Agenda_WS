package br.com.mind5.business.petSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PetarchSetterPetStore extends InfoSetterTemplate<PetarchInfo> {
	
	@Override protected PetarchInfo setAttrHook(PetarchInfo recordInfo) {
		PetarchInfo result = new PetarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codPet = recordInfo.codPet;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}
}
