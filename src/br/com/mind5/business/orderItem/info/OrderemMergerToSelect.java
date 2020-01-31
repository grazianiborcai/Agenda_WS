package br.com.mind5.business.orderItem.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderemMergerToSelect extends InfoMergerTemplate_<OrderemInfo, OrderemInfo> {

	@Override protected InfoMergerVisitor_<OrderemInfo, OrderemInfo> getVisitorHook() {
		return new OrderemVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
