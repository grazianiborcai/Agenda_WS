package br.com.gda.business.order.info;

import br.com.gda.business.orderSnapshot.info.OrdnapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrderMergerOrdnap extends InfoMergerTemplate<OrderInfo, OrdnapInfo> {

	@Override protected InfoMergerVisitor<OrderInfo, OrdnapInfo> getVisitorHook() {
		return new OrderVisiMergeOrdnap();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
