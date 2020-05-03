package br.com.mind5.business.orderItem.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrderemSetterWeekday extends InfoSetterTemplate<OrderemInfo> {
	
	@Override protected OrderemInfo setAttrHook(OrderemInfo recordInfo) {
		recordInfo.codWeekday = recordInfo.date.getDayOfWeek().getValue();		
		return recordInfo;
	}
}
