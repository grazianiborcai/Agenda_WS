package br.com.mind5.business.orderList.info;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdistMergerCurrency extends InfoMergerTemplate_<OrdistInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitor_<OrdistInfo, CurrencyInfo> getVisitorHook() {
		return new OrdistVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<OrdistInfo> getUniquifierHook() {
		return new OrdistUniquifier();
	}
}
