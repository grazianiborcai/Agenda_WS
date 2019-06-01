package br.com.gda.business.order.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class OrderMergerUsername extends InfoMergerTemplate<OrderInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<OrderInfo, UsernameInfo> getVisitorHook() {
		return new OrderVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
