package br.com.mind5.business.order.info;

import br.com.mind5.business.masterData.info.common.OrderStatus;
import br.com.mind5.info.InfoSetterTemplate;

public final class OrderSetterStatusPlaced extends InfoSetterTemplate<OrderInfo> {
	
	@Override protected OrderInfo setAttrHook(OrderInfo recordInfo) {
		recordInfo.codOrderStatus = OrderStatus.PLACED.getCodStatus();
		return recordInfo;
	}
}
