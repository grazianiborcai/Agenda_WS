package br.com.gda.business.cart.info;

import br.com.gda.business.feeOwner.info.FeewnerInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CartMergerFeewner extends InfoMergerTemplate<CartInfo, FeewnerInfo> {

	@Override protected InfoMergerVisitor<CartInfo, FeewnerInfo> getVisitorHook() {
		return new CartVisiMergeFeewner();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
