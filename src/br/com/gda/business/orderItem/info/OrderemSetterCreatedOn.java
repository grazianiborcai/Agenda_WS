package br.com.gda.business.orderItem.info;

import java.time.LocalDateTime;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class OrderemSetterCreatedOn implements InfoSetter<OrderemInfo> {
	
	public OrderemInfo setAttr(OrderemInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.createdOn = genCreatedOn();
		return recordInfo;
	}
	
	
	
	private void checkArgument(OrderemInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private LocalDateTime genCreatedOn() {
		return DefaultValue.localDateTimeNow();
	}
}
