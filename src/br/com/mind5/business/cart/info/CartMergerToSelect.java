package br.com.mind5.business.cart.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CartMergerToSelect extends InfoMergerTemplate_<CartInfo, CartInfo> {

	@Override protected InfoMergerVisitor_<CartInfo, CartInfo> getVisitorHook() {
		return new CartVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
