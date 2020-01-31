package br.com.mind5.business.order.info;

import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderMergerOrderStatus extends InfoMergerTemplate_<OrderInfo, OrderStatusInfo> {

	@Override protected InfoMergerVisitor_<OrderInfo, OrderStatusInfo> getVisitorHook() {
		return new OrderVisiMergeOrderStatus();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
