package br.com.mind5.payment.payOrderItem.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PayordemSetterSysReceiver_ implements InfoSetter<PayordemInfo> {
	
	public PayordemInfo setAttr(PayordemInfo recordInfo) {
		checkArgument(recordInfo);
		return setIsSystemReceiver(recordInfo);
	}
	
	
	
	private void checkArgument(PayordemInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PayordemInfo setIsSystemReceiver(PayordemInfo recordInfo) {
		recordInfo.isSystemReceiver = true;	
		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
