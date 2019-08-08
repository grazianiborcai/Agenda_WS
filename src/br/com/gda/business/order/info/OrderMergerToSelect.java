package br.com.gda.business.order.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrderMergerToSelect extends InfoMergerTemplate<OrderInfo, OrderInfo> {

	@Override protected InfoMergerVisitor<OrderInfo, OrderInfo> getVisitorHook() {
		return new OrderVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
