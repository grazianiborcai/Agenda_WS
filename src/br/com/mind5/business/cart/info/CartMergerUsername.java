package br.com.mind5.business.cart.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class CartMergerUsername extends InfoMergerTemplate_<CartInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<CartInfo, UsernameInfo> getVisitorHook() {
		return new CartVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
