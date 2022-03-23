package br.com.mind5.business.cart.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.currency.info.CurrencyInfo;

final class CartMergerVisiCurrency extends InfoMergerVisitorTemplate<CartInfo, CurrencyInfo> {

	@Override public boolean shouldMerge(CartInfo baseInfo, CurrencyInfo selectedInfo) {
		return (baseInfo.codCurr.equals(selectedInfo.codCurr)		);
	}
	
	
	
	@Override public List<CartInfo> merge(CartInfo baseInfo, CurrencyInfo selectedInfo) {
		List<CartInfo> results = new ArrayList<>();
		
		baseInfo.txtCurr = selectedInfo.txtCurr;
		
		results.add(baseInfo);
		return results;
	}
}
