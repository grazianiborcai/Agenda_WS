package br.com.mind5.business.pet.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PetSetterCreatedBy extends InfoSetterTemplate<PetInfo> {
	
	@Override protected PetInfo setAttrHook(PetInfo recordInfo) {		
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
