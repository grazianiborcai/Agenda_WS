package br.com.mind5.business.order.info;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderMergerOrderem extends InfoMergerTemplate_<OrderInfo, OrderemInfo> {

	@Override protected InfoMergerVisitor_<OrderInfo, OrderemInfo> getVisitorHook() {
		return new OrderVisiMergeOrderem();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
