package br.com.mind5.business.cart.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartMergerToSelect extends InfoMergerTemplate<CartInfo, CartInfo> {

	@Override protected InfoMergerVisitor<CartInfo, CartInfo> getVisitorHook() {
		return new CartVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
