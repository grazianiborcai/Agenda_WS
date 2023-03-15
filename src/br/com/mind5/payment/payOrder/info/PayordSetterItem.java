package br.com.mind5.payment.payOrder.info;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordSetterItem extends InfoSetterTemplate<PayordInfo> {
	
	@Override protected PayordInfo setAttrHook(PayordInfo recordInfo) {
		int itemNum = 2;
		
		for(OrderemInfo eachItem : recordInfo.orderData.orderms) {
			PayordemInfo oneItem = PayordemInfo.copyFrom(eachItem);
			
			oneItem.codPayPartner = recordInfo.codPayPartner;
			oneItem.codPayOrder = recordInfo.codPayOrder;
			oneItem.codPayOrderItem = itemNum++;
			
			recordInfo.payordems.add(oneItem);
		}
		
		return recordInfo;
	}
}
