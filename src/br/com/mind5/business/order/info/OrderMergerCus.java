package br.com.mind5.business.order.info;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderMergerCus extends InfoMergerTemplate_<OrderInfo, CusInfo> {

	@Override protected InfoMergerVisitor_<OrderInfo, CusInfo> getVisitorHook() {
		return new OrderVisiMergeCus();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
