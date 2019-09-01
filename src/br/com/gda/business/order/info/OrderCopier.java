package br.com.gda.business.order.info;

import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.info.InfoCopier;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.refundOrder.info.RefuInfo;

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
	
	
	
	public static OrderInfo copyFromPayord(PayordInfo source) {
		InfoCopier<OrderInfo, PayordInfo> copier = new OrderCopyPayord();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrderInfo> copyFromPayord(List<PayordInfo> sources) {
		InfoCopier<OrderInfo, PayordInfo> copier = new OrderCopyPayord();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static OrderInfo copyToSelect(OrderInfo source) {
		InfoCopier<OrderInfo, OrderInfo> copier = new OrderCopyToSelect();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrderInfo> copyToSelect(List<OrderInfo> sources) {
		InfoCopier<OrderInfo, OrderInfo> copier = new OrderCopyToSelect();
		return copier.makeCopy(sources);
	}
}
