package br.com.mind5.business.storeList.info;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StolisMergerCurrency extends InfoMergerTemplate_<StolisInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitor_<StolisInfo, CurrencyInfo> getVisitorHook() {
		return new StolisVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
