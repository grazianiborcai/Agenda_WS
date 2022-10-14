package br.com.mind5.business.address.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class AddressSetterPeregKey extends InfoSetterTemplate<AddressInfo> {
	
	@Override protected AddressInfo setAttrHook(AddressInfo recordInfo) {
		recordInfo.codCustomer 	= DefaultValue.number();
		recordInfo.codStore 	= DefaultValue.number();
		recordInfo.codEmployee 	= DefaultValue.number();
		recordInfo.codUser 		= DefaultValue.number();
		recordInfo.codOwnerRef 	= DefaultValue.number();
		
		return recordInfo;
	}
}
