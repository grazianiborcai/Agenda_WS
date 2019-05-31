package br.com.gda.business.cart.info;

import br.com.gda.business.feeDefault.info.FeedefInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartMergerFeedef extends InfoMergerTemplate<CartInfo, FeedefInfo> {

	@Override protected InfoMergerVisitorV2<CartInfo, FeedefInfo> getVisitorHook() {
		return new CartVisiMergeFeedef();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
