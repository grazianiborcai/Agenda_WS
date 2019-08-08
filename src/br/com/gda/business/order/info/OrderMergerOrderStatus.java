package br.com.gda.business.order.info;

import br.com.gda.business.masterData.info.OrderStatusInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrderMergerOrderStatus extends InfoMergerTemplate<OrderInfo, OrderStatusInfo> {

	@Override protected InfoMergerVisitor<OrderInfo, OrderStatusInfo> getVisitorHook() {
		return new OrderVisiMergeOrderStatus();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
