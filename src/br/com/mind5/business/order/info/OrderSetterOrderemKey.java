package br.com.mind5.business.order.info;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class OrderSetterOrderemKey implements InfoSetter<OrderInfo> {
	
	public OrderInfo setAttr(OrderInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(OrderInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private OrderInfo setKey(OrderInfo recordInfo) {
		int i=0;
		
		for(OrderemInfo eachCartem : recordInfo.orderms) {
			eachCartem.codOwner = recordInfo.codOwner;
			eachCartem.codOrder = recordInfo.codOrder;
			eachCartem.codOrderItem = ++i;
			eachCartem.username = recordInfo.username;
			eachCartem.codLanguage = recordInfo.codLanguage;
		}
		
		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
