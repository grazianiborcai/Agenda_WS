package br.com.mind5.business.cartItemSearch.info;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class CartemarchCopyCartemKey extends InfoCopierTemplate<CartemarchInfo, CartemInfo> {
	
	public CartemarchCopyCartemKey() {
		super();
	}
	
	
	
	@Override protected CartemarchInfo makeCopyHook(CartemInfo source) {	
		CartemarchInfo result = new CartemarchInfo();
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.username	= source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
