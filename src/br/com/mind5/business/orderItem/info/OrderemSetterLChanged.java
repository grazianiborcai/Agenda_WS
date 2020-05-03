package br.com.mind5.business.orderItem.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class OrderemSetterLChanged extends InfoSetterTemplate<OrderemInfo> {
	
	@Override protected OrderemInfo setAttrHook(OrderemInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
