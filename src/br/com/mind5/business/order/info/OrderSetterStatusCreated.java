package br.com.mind5.business.order.info;

import br.com.mind5.business.masterData.info.common.OrderStatus;
import br.com.mind5.info.InfoSetterTemplate;

public final class OrderSetterStatusCreated extends InfoSetterTemplate<OrderInfo> {
	
	@Override protected OrderInfo setAttrHook(OrderInfo recordInfo) {
		recordInfo.codOrderStatus = OrderStatus.CREATED.getCodStatus();
		return recordInfo;
	}
}
