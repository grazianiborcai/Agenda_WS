package br.com.mind5.business.cart.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartMergerCuslis extends InfoMergerTemplate<CartInfo, CuslisInfo> {

	@Override protected InfoMergerVisitor<CartInfo, CuslisInfo> getVisitorHook() {
		return new CartVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
