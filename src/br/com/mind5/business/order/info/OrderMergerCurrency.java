package br.com.mind5.business.order.info;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderMergerCurrency extends InfoMergerTemplate<OrderInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitor<OrderInfo, CurrencyInfo> getVisitorHook() {
		return new OrderVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
