package br.com.gda.business.order.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
