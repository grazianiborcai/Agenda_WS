package br.com.mind5.business.cart.info;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CartMergerFeewner extends InfoMergerTemplate_<CartInfo, FeewnerInfo> {

	@Override protected InfoMergerVisitor_<CartInfo, FeewnerInfo> getVisitorHook() {
		return new CartVisiMergeFeewner();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
