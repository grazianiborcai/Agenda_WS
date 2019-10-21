package br.com.mind5.business.orderList.info;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrdistMergerCurrency extends InfoMergerTemplate<OrdistInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitor<OrdistInfo, CurrencyInfo> getVisitorHook() {
		return new OrdistVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<OrdistInfo> getUniquifierHook() {
		return new OrdistUniquifier();
	}
}
