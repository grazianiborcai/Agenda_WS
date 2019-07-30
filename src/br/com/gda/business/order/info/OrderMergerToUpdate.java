package br.com.gda.business.order.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OrderMergerToUpdate extends InfoMergerTemplate<OrderInfo, OrderInfo> {

	@Override protected InfoMergerVisitorV2<OrderInfo, OrderInfo> getVisitorHook() {
		return new OrderVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
