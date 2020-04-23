package br.com.mind5.business.store.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class StoreSetterAddressKey extends InfoSetterTemplate<StoreInfo> {
	
	@Override protected StoreInfo setAttrHook(StoreInfo recordInfo) {
		for (AddressInfo eachAddress : recordInfo.addresses) {
			eachAddress.codOwner = recordInfo.codOwner;
			eachAddress.codStore = recordInfo.codStore;
			eachAddress.username = recordInfo.username;
		//	eachAddress.lastChangedBy = recordInfo.lastChangedBy;	//TODO: remover
			eachAddress.codLanguage = recordInfo.codLanguage;
		}
		
		return recordInfo;
	}
}
