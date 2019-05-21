package br.com.gda.business.cart.info;

import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartMergerFeetore extends InfoMergerTemplate<CartInfo, FeetoreInfo> {

	@Override protected InfoMergerVisitorV2<CartInfo, FeetoreInfo> getVisitorHook() {
		return new CartVisiMergeFeetore();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
