package br.com.mind5.business.customer.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CusSetterUserData extends InfoSetterTemplate<CusInfo> {
	
	@Override protected CusInfo setAttrHook(CusInfo recordInfo) {
		recordInfo.codUser = recordInfo.userData.codUser;
		recordInfo.addresses = recordInfo.userData.addresses;
		recordInfo.phones = recordInfo.userData.phones;
		recordInfo.personData = recordInfo.userData.personData;
		
		return recordInfo;
	}
}
