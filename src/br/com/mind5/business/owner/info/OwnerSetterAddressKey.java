package br.com.mind5.business.owner.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class OwnerSetterAddressKey extends InfoSetterTemplate<OwnerInfo> {
	
	@Override protected OwnerInfo setAttrHook(OwnerInfo recordInfo) {
		for (AddressInfo eachAddress : recordInfo.addresses) {
			eachAddress.codOwner = recordInfo.codOwner;
			eachAddress.codOwnerRef = recordInfo.codOwner;
			eachAddress.codLanguage = recordInfo.codLanguage;
			eachAddress.username = recordInfo.username;
		}
		
		return recordInfo;
	}
}
