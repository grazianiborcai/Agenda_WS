package br.com.mind5.payment.payOrder.info;

import java.time.LocalDateTime;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PayordSetterCreatedOn implements InfoSetter<PayordInfo> {
	
	public PayordInfo setAttr(PayordInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.createdOn = genCreatedOn();
		return recordInfo;
	}
	
	
	
	private void checkArgument(PayordInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private LocalDateTime genCreatedOn() {
		return DefaultValue.localDateTimeNow();
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
