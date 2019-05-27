package br.com.gda.business.cartItem.info;


import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

public final class CartemCopier {
	public static List<CartemInfo> copyFromCart(CartInfo source) {
		InfoCopierOneToManyTemplate<CartemInfo, CartInfo> copier = new CartemCopyCart();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CartemInfo> copyFromCart(List<CartInfo> sources) {
		InfoCopierOneToManyTemplate<CartemInfo, CartInfo> copier = new CartemCopyCart();
		return copier.makeCopy(sources);
	}
}
