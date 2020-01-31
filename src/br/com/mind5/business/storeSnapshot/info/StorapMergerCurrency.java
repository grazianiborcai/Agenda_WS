package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StorapMergerCurrency extends InfoMergerTemplate_<StorapInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitor_<StorapInfo, CurrencyInfo> getVisitorHook() {
		return new StorapVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
