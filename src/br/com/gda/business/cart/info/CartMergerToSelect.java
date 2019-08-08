package br.com.gda.business.cart.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CartMergerToSelect extends InfoMergerTemplate<CartInfo, CartInfo> {

	@Override protected InfoMergerVisitor<CartInfo, CartInfo> getVisitorHook() {
		return new CartVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
