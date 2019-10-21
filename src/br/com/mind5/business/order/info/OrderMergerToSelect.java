package br.com.mind5.business.order.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderMergerToSelect extends InfoMergerTemplate<OrderInfo, OrderInfo> {

	@Override protected InfoMergerVisitor<OrderInfo, OrderInfo> getVisitorHook() {
		return new OrderVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
