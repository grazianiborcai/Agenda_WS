package br.com.mind5.business.orderReserve.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderveMergerToSelect extends InfoMergerTemplate<OrderveInfo, OrderveInfo> {

	@Override protected InfoMergerVisitor<OrderveInfo, OrderveInfo> getVisitorHook() {
		return new OrderveVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrderveInfo> getUniquifierHook() {
		return new OrderveUniquifier();
	}
}
