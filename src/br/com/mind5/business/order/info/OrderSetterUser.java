package br.com.mind5.business.order.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrderSetterUser extends InfoSetterTemplate<OrderInfo> {
	
	@Override protected OrderInfo setAttrHook(OrderInfo recordInfo) {
		recordInfo.codUser = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
