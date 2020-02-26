package br.com.mind5.payment.payOrder.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordSetterItem implements InfoSetter<PayordInfo> {
	
	public PayordInfo setAttr(PayordInfo recordInfo) {
		checkArgument(recordInfo);
		
		int itemNum = 2;
		
		for(OrderemInfo eachItem : recordInfo.orderData.orderms) {
			PayordemInfo oneItem = PayordemInfo.copyFrom(eachItem);
			
			oneItem.codPayOrder = recordInfo.codPayOrder;
			oneItem.codPayOrderItem = itemNum++;
			
			recordInfo.payordems.add(oneItem);
		}
		
		return recordInfo;
	}
	
	
	
	private void checkArgument(PayordInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
