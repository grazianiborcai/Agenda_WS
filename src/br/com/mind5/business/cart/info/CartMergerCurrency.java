package br.com.mind5.business.cart.info;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartMergerCurrency extends InfoMergerTemplate<CartInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitor<CartInfo, CurrencyInfo> getVisitorHook() {
		return new CartVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
