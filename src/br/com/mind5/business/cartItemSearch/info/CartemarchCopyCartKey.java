package br.com.mind5.business.cartItemSearch.info;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class CartemarchCopyCartKey extends InfoCopierTemplate<CartemarchInfo, CartInfo>{
	
	public CartemarchCopyCartKey() {
		super();
	}
	
	
	
	@Override protected CartemarchInfo makeCopyHook(CartInfo source) {	
		CartemarchInfo result = new CartemarchInfo();
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.username	= source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
