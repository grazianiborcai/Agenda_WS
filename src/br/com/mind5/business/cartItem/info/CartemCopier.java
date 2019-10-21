package br.com.mind5.business.cartItem.info;


import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;
import br.com.mind5.info.InfoCopierTemplate;

public final class CartemCopier {
	public static List<CartemInfo> copyFromCart(CartInfo source) {
		InfoCopierOneToManyTemplate<CartemInfo, CartInfo> copier = new CartemCopyCart();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CartemInfo> copyFromCart(List<CartInfo> sources) {
		InfoCopierOneToManyTemplate<CartemInfo, CartInfo> copier = new CartemCopyCart();
		return copier.makeCopy(sources);
	}
	
	
	
	public static CartemInfo copyFromCartKey(CartInfo source) {
		InfoCopierTemplate<CartemInfo, CartInfo> copier = new CartemCopyCartKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CartemInfo> copyFromCartKey(List<CartInfo> sources) {
		InfoCopierTemplate<CartemInfo, CartInfo> copier = new CartemCopyCartKey();
		return copier.makeCopy(sources);
	}
}
