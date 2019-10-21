package br.com.mind5.business.order.info;

import br.com.mind5.business.masterData.info.common.OrderStatus;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class OrderSetterStatusRefunding implements InfoSetter<OrderInfo> {
	
	public OrderInfo setAttr(OrderInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.codOrderStatus = OrderStatus.REFUNDING.getCodStatus();
		return recordInfo;
	}
	
	
	
	private void checkArgument(OrderInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
