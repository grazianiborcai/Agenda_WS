package br.com.mind5.business.cartItem.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CartemSetterUserKey extends InfoSetterTemplate<CartemInfo> {
	
	@Override protected CartemInfo setAttrHook(CartemInfo recordInfo) {
		CartemInfo enforcedInfo = new CartemInfo();
		
		enforcedInfo.codOwner = recordInfo.codOwner;
		enforcedInfo.codUser = recordInfo.codUser;
		enforcedInfo.codLanguage = recordInfo.codLanguage;	
		enforcedInfo.username = recordInfo.username;	
		
		return enforcedInfo;
	}
}
