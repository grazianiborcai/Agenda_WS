package br.com.gda.business.order.info;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.orderItem.info.OrderemCopier;
import br.com.gda.info.InfoCopierTemplate;

final class OrderCopyCart extends InfoCopierTemplate<OrderInfo, CartInfo>{
	
	public OrderCopyCart() {
		super();
	}
	
	
	
	@Override protected OrderInfo makeCopyHook(CartInfo source) {		
		OrderInfo result = OrderInfo.copyFrom(source);
		result.orderms = OrderemCopier.copyFromCartem(source.cartems);
		return result;
	}
}
