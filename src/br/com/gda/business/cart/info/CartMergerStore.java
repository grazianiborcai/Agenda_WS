package br.com.gda.business.cart.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartMergerStore extends InfoMergerTemplate<CartInfo, StoreInfo> {

	@Override protected InfoMergerVisitorV2<CartInfo, StoreInfo> getVisitorHook() {
		return new CartVisiMergeStore();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
