package br.com.gda.business.order.info;

import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrderMergerCusarch extends InfoMergerTemplate<OrderInfo, CusarchInfo> {

	@Override protected InfoMergerVisitor<OrderInfo, CusarchInfo> getVisitorHook() {
		return new OrderVisiMergeCusarch();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
