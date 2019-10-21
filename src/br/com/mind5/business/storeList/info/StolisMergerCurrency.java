package br.com.mind5.business.storeList.info;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StolisMergerCurrency extends InfoMergerTemplate<StolisInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitor<StolisInfo, CurrencyInfo> getVisitorHook() {
		return new StolisVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
