package br.com.gda.business.cart.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class CartMergerUsername extends InfoMergerTemplate<CartInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<CartInfo, UsernameInfo> getVisitorHook() {
		return new CartVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
