package br.com.gda.business.cartSnapshot.info;

import java.util.List;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.info.InfoMerger;

final class CartSnapMergerCurrency extends InfoMerger<CartSnapInfo, CurrencyInfo, CartSnapInfo> {
	public CartSnapInfo merge(CurrencyInfo sourceOne, CartSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartSnapVisitorCurrency());
	}
	
	
	
	public List<CartSnapInfo> merge(List<CurrencyInfo> sourceOnes, List<CartSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartSnapVisitorCurrency());
	}
}
