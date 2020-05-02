package br.com.mind5.business.order.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrderSetterCreatedBy extends InfoSetterTemplate<OrderInfo> {
	
	@Override protected OrderInfo setAttrHook(OrderInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
