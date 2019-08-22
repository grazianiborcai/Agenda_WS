package br.com.gda.business.order.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.security.userList.info.UselisInfo;
import br.com.gda.info.InfoUniquifier;

final class OrderMergerUselis extends InfoMergerTemplate<OrderInfo, UselisInfo> {

	@Override protected InfoMergerVisitor<OrderInfo, UselisInfo> getVisitorHook() {
		return new OrderVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
