package br.com.gda.business.cart.info;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CartMergerCartem extends InfoMergerTemplate<CartInfo, CartemInfo> {

	@Override protected InfoMergerVisitor<CartInfo, CartemInfo> getVisitorHook() {
		return new CartVisiMergeCartem();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
