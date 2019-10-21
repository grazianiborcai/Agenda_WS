package br.com.mind5.business.cart.info;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartMergerOrder extends InfoMergerTemplate<CartInfo, OrderInfo> {

	@Override protected InfoMergerVisitor<CartInfo, OrderInfo> getVisitorHook() {
		return new CartVisiMergeOrder();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
