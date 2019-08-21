package br.com.gda.business.orderList.info;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrdistMergerCurrency extends InfoMergerTemplate<OrdistInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitor<OrdistInfo, CurrencyInfo> getVisitorHook() {
		return new OrdistVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<OrdistInfo> getUniquifierHook() {
		return new OrdistUniquifier();
	}
}
