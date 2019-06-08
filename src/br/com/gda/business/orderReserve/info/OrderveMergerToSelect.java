package br.com.gda.business.orderReserve.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OrderveMergerToSelect extends InfoMergerTemplate<OrderveInfo, OrderveInfo> {

	@Override protected InfoMergerVisitorV2<OrderveInfo, OrderveInfo> getVisitorHook() {
		return new OrderveVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrderveInfo> getUniquifierHook() {
		return new OrderveUniquifier();
	}
}
