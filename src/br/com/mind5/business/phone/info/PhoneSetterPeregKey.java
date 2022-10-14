package br.com.mind5.business.phone.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class PhoneSetterPeregKey extends InfoSetterTemplate<PhoneInfo> {
	
	@Override protected PhoneInfo setAttrHook(PhoneInfo recordInfo) {
		recordInfo.codCustomer 	= DefaultValue.number();
		recordInfo.codStore 	= DefaultValue.number();
		recordInfo.codEmployee 	= DefaultValue.number();
		recordInfo.codUser 		= DefaultValue.number();
		recordInfo.codOwnerRef 	= DefaultValue.number();
		
		return recordInfo;
	}
}
