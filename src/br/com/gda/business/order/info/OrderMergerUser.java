package br.com.gda.business.order.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.user.info.UserInfo;

final class OrderMergerUser extends InfoMergerTemplate<OrderInfo, UserInfo> {

	@Override protected InfoMergerVisitorV2<OrderInfo, UserInfo> getVisitorHook() {
		return new OrderVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
