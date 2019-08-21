package br.com.gda.business.orderList.info;

import br.com.gda.business.masterData.info.OrderStatusInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrdistMergerOrderStatus extends InfoMergerTemplate<OrdistInfo, OrderStatusInfo> {

	@Override protected InfoMergerVisitor<OrdistInfo, OrderStatusInfo> getVisitorHook() {
		return new OrdistVisiMergeOrderStatus();
	}
	
	
	
	@Override protected InfoUniquifier<OrdistInfo> getUniquifierHook() {
		return new OrdistUniquifier();
	}
}
