package br.com.mind5.business.order.info;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderMergerCus extends InfoMergerTemplate<OrderInfo, CusInfo> {

	@Override protected InfoMergerVisitor<OrderInfo, CusInfo> getVisitorHook() {
		return new OrderVisiMergeCus();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
