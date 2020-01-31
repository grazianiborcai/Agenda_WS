package br.com.mind5.business.order.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class OrderMergerPayord extends InfoMergerTemplate_<OrderInfo, PayordInfo> {

	@Override protected InfoMergerVisitor_<OrderInfo, PayordInfo> getVisitorHook() {
		return new OrderVisiMergePayord();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
