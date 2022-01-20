package br.com.mind5.business.pet.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class PetSetterStoreKey extends InfoSetterTemplate<PetInfo> {
	
	@Override protected PetInfo setAttrHook(PetInfo recordInfo) {	
		recordInfo.codCustomer = DefaultValue.number();
		recordInfo.codStore = DefaultValue.number();
		
		return recordInfo;
	}
}
