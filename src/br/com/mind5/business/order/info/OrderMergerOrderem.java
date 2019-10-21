package br.com.mind5.business.order.info;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderMergerOrderem extends InfoMergerTemplate<OrderInfo, OrderemInfo> {

	@Override protected InfoMergerVisitor<OrderInfo, OrderemInfo> getVisitorHook() {
		return new OrderVisiMergeOrderem();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
