package br.com.mind5.business.order.info;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderMergerCusarch extends InfoMergerTemplate_<OrderInfo, CusarchInfo> {

	@Override protected InfoMergerVisitor_<OrderInfo, CusarchInfo> getVisitorHook() {
		return new OrderVisiMergeCusarch();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
