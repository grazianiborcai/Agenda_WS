package br.com.mind5.business.cartItem.info;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class CartemCopyCartKey extends InfoCopierTemplate<CartemInfo, CartInfo>{
	
	public CartemCopyCartKey() {
		super();
	}
	
	
	
	@Override protected CartemInfo makeCopyHook(CartInfo source) {	
		CartemInfo result = new CartemInfo();
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.username	= source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
