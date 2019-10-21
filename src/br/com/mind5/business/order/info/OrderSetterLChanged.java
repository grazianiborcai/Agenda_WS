package br.com.mind5.business.order.info;

import java.time.LocalDateTime;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class OrderSetterLChanged implements InfoSetter<OrderInfo> {
	
	public OrderInfo setAttr(OrderInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.lastChanged = genLastChanged();
		return recordInfo;
	}
	
	
	
	private void checkArgument(OrderInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private LocalDateTime genLastChanged() {
		return DefaultValue.localDateTimeNow();
	}
}
