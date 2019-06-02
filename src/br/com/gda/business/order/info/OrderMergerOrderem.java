package br.com.gda.business.order.info;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OrderMergerOrderem extends InfoMergerTemplate<OrderInfo, OrderemInfo> {

	@Override protected InfoMergerVisitorV2<OrderInfo, OrderemInfo> getVisitorHook() {
		return new OrderVisiMergeOrderem();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
