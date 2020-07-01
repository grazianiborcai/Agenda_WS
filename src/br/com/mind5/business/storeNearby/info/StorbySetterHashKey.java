package br.com.mind5.business.storeNearby.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StorbySetterHashKey extends InfoSetterTemplate<StorbyInfo> {
	
	@Override protected StorbyInfo setAttrHook(StorbyInfo recordInfo) {
		StorbyInfo result = new StorbyInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.longitude = recordInfo.longitude;
		result.latitude = recordInfo.latitude;
		result.geoHash03 = recordInfo.geoHash03;
		result.geoHash04 = recordInfo.geoHash04;
		result.geoHash05 = recordInfo.geoHash05;
		result.geoHash12 = recordInfo.geoHash12;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
}
