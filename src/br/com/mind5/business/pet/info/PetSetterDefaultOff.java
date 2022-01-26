package br.com.mind5.business.pet.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PetSetterDefaultOff extends InfoSetterTemplate<PetInfo> {
	
	@Override protected PetInfo setAttrHook(PetInfo recordInfo) {	
		recordInfo.isDefault = false;
		return recordInfo;
	}
}
