package br.com.gda.payment.payOrder.info;

import br.com.gda.business.masterData.info.common.PaymentStatus;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class PayordSetterStatusWaiting implements InfoSetter<PayordInfo> {
	
	public PayordInfo setAttr(PayordInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.codPaymentStatus = PaymentStatus.WAITING.getCodStatus();
		return recordInfo;
	}
	
	
	
	private void checkArgument(PayordInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
