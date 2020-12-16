package br.com.mind5.business.cartItemSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CartemarchSetterUserKey extends InfoSetterTemplate<CartemarchInfo> {
	
	@Override protected CartemarchInfo setAttrHook(CartemarchInfo recordInfo) {
		CartemarchInfo result = new CartemarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codUser = recordInfo.codUser;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
}
