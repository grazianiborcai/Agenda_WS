package br.com.mind5.business.customer.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CusSetterPhoneKey extends InfoSetterTemplate<CusInfo> {
	
	@Override protected CusInfo setAttrHook(CusInfo recordInfo) {
		for (PhoneInfo eachRecord : recordInfo.phones) {
			eachRecord.codOwner = recordInfo.codOwner;
			eachRecord.codCustomer = recordInfo.codCustomer;
			eachRecord.codStore = DefaultValue.number();
			eachRecord.codEmployee = DefaultValue.number();
			eachRecord.codUser = DefaultValue.number();
			eachRecord.codOwnerRef = DefaultValue.number();
			eachRecord.codLanguage = recordInfo.codLanguage;
			eachRecord.username = recordInfo.username;
		}
		
		return recordInfo;
	}
}
