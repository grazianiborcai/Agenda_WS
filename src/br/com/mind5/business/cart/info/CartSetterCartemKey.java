package br.com.mind5.business.cart.info;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class CartSetterCartemKey extends InfoSetterTemplate<CartInfo> {
	
	@Override protected CartInfo setAttrHook(CartInfo recordInfo) {
		for(CartemInfo eachCartem : recordInfo.cartems) {
			eachCartem.codOwner = recordInfo.codOwner;
			eachCartem.codUser = recordInfo.codUser;
			eachCartem.username = recordInfo.username;
			eachCartem.codLanguage = recordInfo.codLanguage;
		}
		
		return recordInfo;
	}	
}
