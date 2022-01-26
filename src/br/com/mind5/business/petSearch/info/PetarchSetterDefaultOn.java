package br.com.mind5.business.petSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PetarchSetterDefaultOn extends InfoSetterTemplate<PetarchInfo> {
	
	@Override protected PetarchInfo setAttrHook(PetarchInfo recordInfo) {	
		recordInfo.isDefault = true;
		return recordInfo;
	}
}
