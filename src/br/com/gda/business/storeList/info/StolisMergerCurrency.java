package br.com.gda.business.storeList.info;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class StolisMergerCurrency extends InfoMergerTemplate<StolisInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitorV2<StolisInfo, CurrencyInfo> getVisitorHook() {
		return new StolisVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
