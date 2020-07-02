package br.com.mind5.business.storeNearby.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StorbySetterHash03Key extends InfoSetterTemplate<StorbyInfo> {
	
	@Override protected StorbyInfo setAttrHook(StorbyInfo recordInfo) {
		StorbyInfo result = new StorbyInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.longitude = recordInfo.longitude;
		result.latitude = recordInfo.latitude;
		result.geoHash03 = recordInfo.geoHash03;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
}
