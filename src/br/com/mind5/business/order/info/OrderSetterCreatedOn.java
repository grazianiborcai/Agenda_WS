package br.com.mind5.business.order.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class OrderSetterCreatedOn implements InfoSetter<OrderInfo> {
	
	public OrderInfo setAttr(OrderInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		recordInfo.lastChanged = recordInfo.createdOn;
		return recordInfo;
	}
	
	
	
	private void checkArgument(OrderInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
