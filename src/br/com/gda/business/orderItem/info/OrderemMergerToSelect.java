package br.com.gda.business.orderItem.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OrderemMergerToSelect extends InfoMergerTemplate<OrderemInfo, OrderemInfo> {

	@Override protected InfoMergerVisitorV2<OrderemInfo, OrderemInfo> getVisitorHook() {
		return new OrderemVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
