package br.com.gda.business.order.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class OrderSetterCartemKey implements InfoSetter<OrderInfo> {
	
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
		for(CartemInfo eachCartem : recordInfo.cartems) {
			eachCartem.codOwner = recordInfo.codOwner;
			eachCartem.codUser = recordInfo.codUser;
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
