package br.com.gda.business.cart.info;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartMergerCurrency extends InfoMergerTemplate<CartInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitorV2<CartInfo, CurrencyInfo> getVisitorHook() {
		return new CartVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
