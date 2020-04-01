package br.com.mind5.business.phone.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PhoneSetterCreatedBy implements InfoSetter<PhoneInfo> {
	
	public PhoneInfo setAttr(PhoneInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
	
	
	
	private void checkArgument(PhoneInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
