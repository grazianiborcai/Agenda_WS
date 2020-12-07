package br.com.mind5.business.cartItemSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CartemarchSetterUserKey extends InfoSetterTemplate<CartemarchInfo> {
	
	@Override protected CartemarchInfo setAttrHook(CartemarchInfo recordInfo) {
		CartemarchInfo result = new CartemarchInfo();
		
		result.codOwner = result.codOwner;
		result.codUser = result.codUser;
		result.codLanguage = result.codLanguage;
		result.username = result.username;
		
		return result;
	}
}
