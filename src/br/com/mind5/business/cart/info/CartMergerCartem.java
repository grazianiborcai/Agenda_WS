package br.com.mind5.business.cart.info;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CartMergerCartem extends InfoMergerTemplate_<CartInfo, CartemInfo> {

	@Override protected InfoMergerVisitor_<CartInfo, CartemInfo> getVisitorHook() {
		return new CartVisiMergeCartem();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
