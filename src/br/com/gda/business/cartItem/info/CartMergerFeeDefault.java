package br.com.gda.business.cartItem.info;

import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartMergerFeeDefault extends InfoMergerTemplate<CartInfo, FeeDefaultInfo> {

	@Override protected InfoMergerVisitorV2<CartInfo, FeeDefaultInfo> getVisitorHook() {
		return new CartVisiMergeFeeDefault();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
