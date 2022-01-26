package br.com.mind5.business.pet.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PetSetterDefaultOn extends InfoSetterTemplate<PetInfo> {
	
	@Override protected PetInfo setAttrHook(PetInfo recordInfo) {	
		recordInfo.isDefault = true;
		return recordInfo;
	}
}
