package br.com.gda.payment.payOrder.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

public final class PayordSetterItemNum_ implements InfoSetter<PayordInfo> {
	
	public PayordInfo setAttr(PayordInfo recordInfo) {
		checkArgument(recordInfo);
		
		int itemNum = 1;
		
		for(PayordemInfo eachItem : recordInfo.payordems) {
			eachItem.itemNum = itemNum++;
		}		

		return recordInfo;
	}
	
	
	
	private void checkArgument(PayordInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
