package br.com.gda.business.cartItem.info;

import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartMergerCartCateg extends InfoMergerTemplate<CartInfo, CartCategInfo> {

	@Override protected InfoMergerVisitorV2<CartInfo, CartCategInfo> getVisitorHook() {
		return new CartVisiMergeCartCateg();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
