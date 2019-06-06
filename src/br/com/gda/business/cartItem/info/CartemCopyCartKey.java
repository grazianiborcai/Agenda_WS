package br.com.gda.business.cartItem.info;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.info.InfoCopierTemplate;

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
