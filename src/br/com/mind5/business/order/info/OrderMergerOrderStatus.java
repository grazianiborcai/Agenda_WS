package br.com.mind5.business.order.info;

import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderMergerOrderStatus extends InfoMergerTemplate<OrderInfo, OrderStatusInfo> {

	@Override protected InfoMergerVisitor<OrderInfo, OrderStatusInfo> getVisitorHook() {
		return new OrderVisiMergeOrderStatus();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
