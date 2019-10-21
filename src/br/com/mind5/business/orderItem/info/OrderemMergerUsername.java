package br.com.mind5.business.orderItem.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class OrderemMergerUsername extends InfoMergerTemplate<OrderemInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<OrderemInfo, UsernameInfo> getVisitorHook() {
		return new OrderemVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
