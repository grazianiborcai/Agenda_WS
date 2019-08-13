package br.com.gda.business.storeSnapshot.info;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerCurrency extends InfoMergerTemplate<StorapInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, CurrencyInfo> getVisitorHook() {
		return new StoreVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
