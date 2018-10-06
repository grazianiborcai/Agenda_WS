package br.com.gda.business.order.info;

import java.time.LocalDateTime;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class OrderSetterLChanged implements InfoSetter<OrderInfo> {
	
	public OrderInfo setAttr(OrderInfo order) {
		checkArgument(order);
		
		order.lastChanged = genLastChanged();
		return order;
	}
	
	
	
	private void checkArgument(OrderInfo order) {
		if (order == null)
			throw new NullPointerException("order" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private LocalDateTime genLastChanged() {
		return DefaultValue.dateTimeNow();
	}
}
