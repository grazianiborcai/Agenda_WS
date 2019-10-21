package br.com.mind5.business.orderItem.info;

import java.time.LocalDateTime;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class OrderemSetterLChanged implements InfoSetter<OrderemInfo> {
	
	public OrderemInfo setAttr(OrderemInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.lastChanged = genCreatedOn();
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
