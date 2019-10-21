package br.com.mind5.business.order.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class OrderSetterKey implements InfoSetter<OrderInfo> {
	
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
		OrderInfo result = new OrderInfo();
		result.codOwner = recordInfo.codOwner;
		result.codOrder = recordInfo.codOrder;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		return result;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
