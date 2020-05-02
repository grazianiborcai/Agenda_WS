package br.com.mind5.business.order.info;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class OrderSetterOrderemKey extends InfoSetterTemplate<OrderInfo> {
	
	@Override protected OrderInfo setAttrHook(OrderInfo recordInfo) {
		int i=0;
		
		for(OrderemInfo eachCartem : recordInfo.orderms) {
			eachCartem.codOwner = recordInfo.codOwner;
			eachCartem.codOrder = recordInfo.codOrder;
			eachCartem.codOrderItem = ++i;
			eachCartem.username = recordInfo.username;
			eachCartem.codLanguage = recordInfo.codLanguage;
		}
		
		return recordInfo;
	}	
}
