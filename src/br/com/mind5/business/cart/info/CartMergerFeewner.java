package br.com.mind5.business.cart.info;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartMergerFeewner extends InfoMergerTemplate<CartInfo, FeewnerInfo> {

	@Override protected InfoMergerVisitor<CartInfo, FeewnerInfo> getVisitorHook() {
		return new CartVisiMergeFeewner();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
