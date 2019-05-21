package br.com.gda.business.cart.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartMergerMat extends InfoMergerTemplate<CartInfo, MatInfo> {

	@Override protected InfoMergerVisitorV2<CartInfo, MatInfo> getVisitorHook() {
		return new CartVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
