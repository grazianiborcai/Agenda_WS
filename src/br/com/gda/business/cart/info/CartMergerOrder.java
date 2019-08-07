package br.com.gda.business.cart.info;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartMergerOrder extends InfoMergerTemplate<CartInfo, OrderInfo> {

	@Override protected InfoMergerVisitorV2<CartInfo, OrderInfo> getVisitorHook() {
		return new CartVisiMergeOrder();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
