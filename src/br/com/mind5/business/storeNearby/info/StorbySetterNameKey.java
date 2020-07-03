package br.com.mind5.business.storeNearby.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StorbySetterNameKey extends InfoSetterTemplate<StorbyInfo> {
	
	@Override protected StorbyInfo setAttrHook(StorbyInfo recordInfo) {
		StorbyInfo result = new StorbyInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.longitude = recordInfo.longitude;
		result.latitude = recordInfo.latitude;
		result.nameSearch = recordInfo.nameSearch;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
}
