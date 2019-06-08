package br.com.gda.business.orderReserve.info;

import br.com.gda.business.masterData.info.common.OrderStatus;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

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
