package br.com.mind5.business.cart.info;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CartMergerOrder extends InfoMergerTemplate_<CartInfo, OrderInfo> {

	@Override protected InfoMergerVisitor_<CartInfo, OrderInfo> getVisitorHook() {
		return new CartVisiMergeOrder();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
