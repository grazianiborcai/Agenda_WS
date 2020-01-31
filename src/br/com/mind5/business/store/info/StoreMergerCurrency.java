package br.com.mind5.business.store.info;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoreMergerCurrency extends InfoMergerTemplate_<StoreInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitor_<StoreInfo, CurrencyInfo> getVisitorHook() {
		return new StoreVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
