package br.com.gda.business.order.info;

import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.info.InfoCopier;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class OrderCopier {	
	public static OrderInfo copyFromCart(CartInfo source) {
		InfoCopier<OrderInfo, CartInfo> copier = new OrderCopyCart();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrderInfo> copyFromCart(List<CartInfo> sources) {
		InfoCopier<OrderInfo, CartInfo> copier = new OrderCopyCart();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static OrderInfo copyFromPayord(PayordInfo source) {
		InfoCopier<OrderInfo, PayordInfo> copier = new OrderCopyPayord();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrderInfo> copyFromPayord(List<PayordInfo> sources) {
		InfoCopier<OrderInfo, PayordInfo> copier = new OrderCopyPayord();
		return copier.makeCopy(sources);
	}	
}
