package br.com.mind5.business.order.info;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.orderItem.info.OrderemCopier;
import br.com.mind5.info.InfoCopierTemplate;

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
