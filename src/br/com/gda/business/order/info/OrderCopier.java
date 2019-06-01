package br.com.gda.business.order.info;

import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.info.InfoCopier;

public final class OrderCopier {	
	public static OrderInfo copyFromCart(CartInfo source) {
		InfoCopier<OrderInfo, CartInfo> copier = new OrderCopyCart();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrderInfo> copyFromCart(List<CartInfo> sources) {
		InfoCopier<OrderInfo, CartInfo> copier = new OrderCopyCart();
		return copier.makeCopy(sources);
	}	
}
