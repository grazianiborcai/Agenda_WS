package br.com.mind5.business.cart.info;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CartMergerCurrency extends InfoMergerTemplate_<CartInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitor_<CartInfo, CurrencyInfo> getVisitorHook() {
		return new CartVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
