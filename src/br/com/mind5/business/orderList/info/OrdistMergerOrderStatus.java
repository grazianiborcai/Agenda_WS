package br.com.mind5.business.orderList.info;

import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdistMergerOrderStatus extends InfoMergerTemplate_<OrdistInfo, OrderStatusInfo> {

	@Override protected InfoMergerVisitor_<OrdistInfo, OrderStatusInfo> getVisitorHook() {
		return new OrdistVisiMergeOrderStatus();
	}
	
	
	
	@Override protected InfoUniquifier<OrdistInfo> getUniquifierHook() {
		return new OrdistUniquifier();
	}
}
