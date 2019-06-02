package br.com.gda.business.order.info;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OrderMergerUser extends InfoMergerTemplate<OrderInfo, UserInfo> {

	@Override protected InfoMergerVisitorV2<OrderInfo, UserInfo> getVisitorHook() {
		return new OrderVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
