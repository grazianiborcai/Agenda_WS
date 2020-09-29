package br.com.mind5.business.storeTextSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StorextarchSetterStoreKey extends InfoSetterTemplate<StorextarchInfo> {
	
	@Override protected StorextarchInfo setAttrHook(StorextarchInfo recordInfo) {
		StorextarchInfo result = new StorextarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.username = recordInfo.username;
		result.codLanguage = null;
		
		return result;
	}
}
