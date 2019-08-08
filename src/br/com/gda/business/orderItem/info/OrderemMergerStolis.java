package br.com.gda.business.orderItem.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrderemMergerStolis extends InfoMergerTemplate<OrderemInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<OrderemInfo, StolisInfo> getVisitorHook() {
		return new OrderemVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
