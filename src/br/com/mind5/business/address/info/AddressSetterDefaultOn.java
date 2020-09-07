package br.com.mind5.business.address.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class AddressSetterDefaultOn extends InfoSetterTemplate<AddressInfo> {
	
	@Override protected AddressInfo setAttrHook(AddressInfo recordInfo) {	
		recordInfo.isDefault = true;
		return recordInfo;
	}
}
