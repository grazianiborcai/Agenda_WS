package br.com.mind5.business.order.info;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderMergerCusarch extends InfoMergerTemplate<OrderInfo, CusarchInfo> {

	@Override protected InfoMergerVisitor<OrderInfo, CusarchInfo> getVisitorHook() {
		return new OrderVisiMergeCusarch();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
