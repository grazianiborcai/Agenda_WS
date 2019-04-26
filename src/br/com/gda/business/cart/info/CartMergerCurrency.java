package br.com.gda.business.cart.info;

import java.util.List;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.info.InfoMerger_;

final class CartMergerCurrency extends InfoMerger_<CartInfo, CurrencyInfo, CartInfo> {
	public CartInfo merge(CurrencyInfo sourceOne, CartInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartVisitorCurrency());
	}
	
	
	
	public List<CartInfo> merge(List<CurrencyInfo> sourceOnes, List<CartInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartVisitorCurrency());
	}
}
