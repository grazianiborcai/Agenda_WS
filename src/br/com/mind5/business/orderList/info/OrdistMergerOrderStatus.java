package br.com.mind5.business.orderList.info;

import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrdistMergerOrderStatus extends InfoMergerTemplate<OrdistInfo, OrderStatusInfo> {

	@Override protected InfoMergerVisitor<OrdistInfo, OrderStatusInfo> getVisitorHook() {
		return new OrdistVisiMergeOrderStatus();
	}
	
	
	
	@Override protected InfoUniquifier<OrdistInfo> getUniquifierHook() {
		return new OrdistUniquifier();
	}
}
