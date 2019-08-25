package br.com.gda.business.orderItem.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class OrderemMergerUsername extends InfoMergerTemplate<OrderemInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<OrderemInfo, UsernameInfo> getVisitorHook() {
		return new OrderemVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
