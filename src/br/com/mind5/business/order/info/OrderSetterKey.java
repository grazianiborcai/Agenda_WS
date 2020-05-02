package br.com.mind5.business.order.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrderSetterKey extends InfoSetterTemplate<OrderInfo> {
	
	@Override protected OrderInfo setAttrHook(OrderInfo recordInfo) {
		OrderInfo result = new OrderInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codOrder = recordInfo.codOrder;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}
}
