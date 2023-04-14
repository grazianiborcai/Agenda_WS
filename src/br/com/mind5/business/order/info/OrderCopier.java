package br.com.mind5.business.order.info;

import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

public final class OrderCopier {	
	public static OrderInfo copyFromRefu(RefuInfo source) {
		InfoCopier<OrderInfo, RefuInfo> copier = new OrderCopyRefu();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrderInfo> copyFromRefu(List<RefuInfo> sources) {
		InfoCopier<OrderInfo, RefuInfo> copier = new OrderCopyRefu();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static OrderInfo copyFromCart(CartInfo source) {
		InfoCopier<OrderInfo, CartInfo> copier = new OrderCopyCart();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrderInfo> copyFromCart(List<CartInfo> sources) {
		InfoCopier<OrderInfo, CartInfo> copier = new OrderCopyCart();
		return copier.makeCopy(sources);
	}	
}
