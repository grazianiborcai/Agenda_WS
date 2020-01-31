package br.com.mind5.business.order.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class OrderMergerUsername extends InfoMergerTemplate_<OrderInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<OrderInfo, UsernameInfo> getVisitorHook() {
		return new OrderVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
