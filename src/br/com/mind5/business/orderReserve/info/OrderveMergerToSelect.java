package br.com.mind5.business.orderReserve.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderveMergerToSelect extends InfoMergerTemplate_<OrderveInfo, OrderveInfo> {

	@Override protected InfoMergerVisitor_<OrderveInfo, OrderveInfo> getVisitorHook() {
		return new OrderveVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrderveInfo> getUniquifierHook() {
		return new OrderveUniquifier();
	}
}
