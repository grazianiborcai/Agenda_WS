package br.com.mind5.business.address.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class AddressSetterCreatedBy extends InfoSetterTemplate<AddressInfo> {
	
	@Override protected AddressInfo setAttrHook(AddressInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
