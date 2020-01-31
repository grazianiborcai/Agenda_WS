package br.com.mind5.business.order.info;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderMergerOrdnap extends InfoMergerTemplate_<OrderInfo, OrdnapInfo> {

	@Override protected InfoMergerVisitor_<OrderInfo, OrdnapInfo> getVisitorHook() {
		return new OrderVisiMergeOrdnap();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
