package br.com.mind5.business.order.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class OrderSetterCreatedOn extends InfoSetterTemplate<OrderInfo> {
	
	@Override protected OrderInfo setAttrHook(OrderInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		recordInfo.lastChanged = recordInfo.createdOn;
		return recordInfo;
	}
}
