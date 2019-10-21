package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderemMergerStolis extends InfoMergerTemplate<OrderemInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<OrderemInfo, StolisInfo> getVisitorHook() {
		return new OrderemVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
