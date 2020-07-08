package br.com.mind5.business.customer.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CusSetterUserData extends InfoSetterTemplate<CusInfo> {
	
	@Override protected CusInfo setAttrHook(CusInfo recordInfo) {
		recordInfo.addresses = recordInfo.addressesUser;
		recordInfo.phones = recordInfo.phonesUser;
		recordInfo.personData = recordInfo.personDataUser;
		
		return recordInfo;
	}
}
