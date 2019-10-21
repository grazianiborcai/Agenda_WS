package br.com.mind5.business.cart.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class CartMergerUsername extends InfoMergerTemplate<CartInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<CartInfo, UsernameInfo> getVisitorHook() {
		return new CartVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
