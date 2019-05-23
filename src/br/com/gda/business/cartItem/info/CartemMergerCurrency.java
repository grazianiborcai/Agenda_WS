package br.com.gda.business.cartItem.info;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartemMergerCurrency extends InfoMergerTemplate<CartemInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitorV2<CartemInfo, CurrencyInfo> getVisitorHook() {
		return new CartemVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
