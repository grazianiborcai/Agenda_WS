package br.com.gda.business.order.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class OrderMergerPayord extends InfoMergerTemplate<OrderInfo, PayordInfo> {

	@Override protected InfoMergerVisitorV2<OrderInfo, PayordInfo> getVisitorHook() {
		return new OrderVisiMergePayord();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
