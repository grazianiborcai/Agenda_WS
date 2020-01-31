package br.com.mind5.business.order.info;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderMergerCurrency extends InfoMergerTemplate_<OrderInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitor_<OrderInfo, CurrencyInfo> getVisitorHook() {
		return new OrderVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
