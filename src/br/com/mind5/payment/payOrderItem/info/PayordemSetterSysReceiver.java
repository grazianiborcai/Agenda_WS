package br.com.mind5.payment.payOrderItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PayordemSetterSysReceiver implements InfoSetter<PayordemInfo> {
	
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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
