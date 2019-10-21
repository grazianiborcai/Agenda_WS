package br.com.mind5.business.order.info;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderMergerOrdnap extends InfoMergerTemplate<OrderInfo, OrdnapInfo> {

	@Override protected InfoMergerVisitor<OrderInfo, OrdnapInfo> getVisitorHook() {
		return new OrderVisiMergeOrdnap();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
