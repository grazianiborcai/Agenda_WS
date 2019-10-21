package br.com.mind5.business.orderItem.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderemMergerToSelect extends InfoMergerTemplate<OrderemInfo, OrderemInfo> {

	@Override protected InfoMergerVisitor<OrderemInfo, OrderemInfo> getVisitorHook() {
		return new OrderemVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
