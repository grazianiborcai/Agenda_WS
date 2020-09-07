package br.com.mind5.business.address.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class AddressSetterDefaultOff extends InfoSetterTemplate<AddressInfo> {
	
	@Override protected AddressInfo setAttrHook(AddressInfo recordInfo) {	
		recordInfo.isDefault = false;
		return recordInfo;
	}
}
