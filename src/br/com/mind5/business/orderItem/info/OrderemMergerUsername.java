package br.com.mind5.business.orderItem.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class OrderemMergerUsername extends InfoMergerTemplate_<OrderemInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<OrderemInfo, UsernameInfo> getVisitorHook() {
		return new OrderemVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
