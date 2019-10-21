package br.com.mind5.business.order.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class OrderMergerUsername extends InfoMergerTemplate<OrderInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<OrderInfo, UsernameInfo> getVisitorHook() {
		return new OrderVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
