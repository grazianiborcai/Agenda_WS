package br.com.mind5.business.order.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class OrderMergerPayord extends InfoMergerTemplate<OrderInfo, PayordInfo> {

	@Override protected InfoMergerVisitor<OrderInfo, PayordInfo> getVisitorHook() {
		return new OrderVisiMergePayord();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
