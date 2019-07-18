package br.com.gda.payment.payOrder.info;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

public final class PayordSetterPayordem_ implements InfoSetter<PayordInfo> {
	
	public PayordInfo setAttr(PayordInfo recordInfo) {
		checkArgument(recordInfo);
		
		
		for(OrderemInfo eachItem : recordInfo.orderData.orderms) {
			PayordemInfo payordem = PayordemInfo.copyFrom(eachItem);
			payordem.codPayOrder = recordInfo.codPayOrder;
			payordem.codPayPartner = recordInfo.codPayPartner;
			
			recordInfo.payordems.add(payordem);
		}
		

		return recordInfo;
	}
	
	
	
	private void checkArgument(PayordInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
