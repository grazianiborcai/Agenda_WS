package br.com.mind5.business.orderReserve.info;

import br.com.mind5.business.masterData.info.common.OrderStatus;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class OrderverSetteCancelled implements InfoSetter<OrderveInfo> {
	
	public OrderveInfo setAttr(OrderveInfo recordInfo) {
		checkArgument(recordInfo);
		return setStatusCancelled(recordInfo);
	}
	
	
	
	private OrderveInfo setStatusCancelled(OrderveInfo recordInfo) {
		recordInfo.codOrderStatus = OrderStatus.CANCELLED.getCodStatus();			
		return recordInfo;
	}
	
	
	
	private void checkArgument(OrderveInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
