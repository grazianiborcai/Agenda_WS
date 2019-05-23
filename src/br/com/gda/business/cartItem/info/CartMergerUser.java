package br.com.gda.business.cartItem.info;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartMergerUser extends InfoMergerTemplate<CartInfo, UserInfo> {

	@Override protected InfoMergerVisitorV2<CartInfo, UserInfo> getVisitorHook() {
		return new CartVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
