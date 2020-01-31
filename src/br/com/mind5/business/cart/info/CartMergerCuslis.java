package br.com.mind5.business.cart.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CartMergerCuslis extends InfoMergerTemplate_<CartInfo, CuslisInfo> {

	@Override protected InfoMergerVisitor_<CartInfo, CuslisInfo> getVisitorHook() {
		return new CartVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
