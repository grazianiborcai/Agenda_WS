package br.com.gda.business.cart.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartMergerToSelect extends InfoMergerTemplate<CartInfo, CartInfo> {

	@Override protected InfoMergerVisitorV2<CartInfo, CartInfo> getVisitorHook() {
		return new CartVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
