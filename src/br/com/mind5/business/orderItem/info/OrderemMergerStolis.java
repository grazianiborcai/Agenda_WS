package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderemMergerStolis extends InfoMergerTemplate_<OrderemInfo, StolisInfo> {

	@Override protected InfoMergerVisitor_<OrderemInfo, StolisInfo> getVisitorHook() {
		return new OrderemVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
