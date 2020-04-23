package br.com.mind5.business.orderReserve.info;

import br.com.mind5.business.masterData.info.common.OrderStatus;
import br.com.mind5.info.InfoSetterTemplate;

public final class OrderverSetteCancelled extends InfoSetterTemplate<OrderveInfo> {
	
	@Override protected OrderveInfo setAttrHook(OrderveInfo recordInfo) {
		recordInfo.codOrderStatus = OrderStatus.CANCELLED.getCodStatus();			
		return recordInfo;
	}
}
