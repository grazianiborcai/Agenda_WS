package br.com.mind5.business.owner.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class OwnerSetterPhoneKey extends InfoSetterTemplate<OwnerInfo> {
	
	@Override protected OwnerInfo setAttrHook(OwnerInfo recordInfo) {
		for (PhoneInfo eachAddress : recordInfo.phones) {
			eachAddress.codOwner = recordInfo.codOwner;
			eachAddress.codOwnerRef = recordInfo.codOwner;
			eachAddress.codLanguage = recordInfo.codLanguage;
			eachAddress.username = recordInfo.username;
		}
		
		return recordInfo;
	}
}
