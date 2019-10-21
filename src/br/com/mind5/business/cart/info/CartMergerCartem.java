package br.com.mind5.business.cart.info;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartMergerCartem extends InfoMergerTemplate<CartInfo, CartemInfo> {

	@Override protected InfoMergerVisitor<CartInfo, CartemInfo> getVisitorHook() {
		return new CartVisiMergeCartem();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
