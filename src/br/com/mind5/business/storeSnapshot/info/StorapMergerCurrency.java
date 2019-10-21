package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StorapMergerCurrency extends InfoMergerTemplate<StorapInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, CurrencyInfo> getVisitorHook() {
		return new StorapVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
