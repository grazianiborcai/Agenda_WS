package br.com.mind5.business.store.info;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoreMergerCurrency extends InfoMergerTemplate<StoreInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, CurrencyInfo> getVisitorHook() {
		return new StoreVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
