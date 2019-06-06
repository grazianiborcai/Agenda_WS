package br.com.gda.business.order.info;

import br.com.gda.business.masterData.info.common.OrderStatus;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class OrderSetterStatusWaiting implements InfoSetter<OrderInfo> {
	
	public OrderInfo setAttr(OrderInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.codOrderStatus = OrderStatus.WAITING.getCodStatus();
		return recordInfo;
	}
	
	
	
	private void checkArgument(OrderInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
