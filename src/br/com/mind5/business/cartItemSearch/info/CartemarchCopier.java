package br.com.mind5.business.cartItemSearch.info;


import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoCopierTemplate;

public final class CartemarchCopier {
	public static CartemarchInfo copyFromCartKey(CartInfo source) {
		InfoCopierTemplate<CartemarchInfo, CartInfo> copier = new CartemarchCopyCartKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CartemarchInfo> copyFromCartKey(List<CartInfo> sources) {
		InfoCopierTemplate<CartemarchInfo, CartInfo> copier = new CartemarchCopyCartKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static CartemarchInfo copyFromCartemKey(CartemInfo source) {
		InfoCopierTemplate<CartemarchInfo, CartemInfo> copier = new CartemarchCopyCartemKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CartemarchInfo> copyFromCartemKey(List<CartemInfo> sources) {
		InfoCopierTemplate<CartemarchInfo, CartemInfo> copier = new CartemarchCopyCartemKey();
		return copier.makeCopy(sources);
	}
}
