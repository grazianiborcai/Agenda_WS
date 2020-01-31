package br.com.mind5.business.order.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderMergerToUpdate extends InfoMergerTemplate_<OrderInfo, OrderInfo> {

	@Override protected InfoMergerVisitor_<OrderInfo, OrderInfo> getVisitorHook() {
		return new OrderVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
