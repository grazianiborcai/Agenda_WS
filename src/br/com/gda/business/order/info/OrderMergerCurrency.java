package br.com.gda.business.order.info;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrderMergerCurrency extends InfoMergerTemplate<OrderInfo, CurrencyInfo> {

	@Override protected InfoMergerVisitor<OrderInfo, CurrencyInfo> getVisitorHook() {
		return new OrderVisiMergeCurrency();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
