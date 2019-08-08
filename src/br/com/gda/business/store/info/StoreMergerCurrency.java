package br.com.gda.business.store.info;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerCurrency extends InfoMergerTemplate<StoreInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, CurrencyInfo> getVisitorHook() {
		return new StoreVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
