package br.com.mind5.business.phone.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PhoneSetterAreaT01 implements InfoSetter<PhoneInfo> {
	private final int AREA_LENGTH = 2;
	
	public PhoneInfo setAttr(PhoneInfo recordInfo) {
		checkArgument(recordInfo);
		recordInfo.codArea = getArea(recordInfo);		
		
		return recordInfo;
	}
	
		
	
	private void checkArgument(PhoneInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private String getArea(PhoneInfo recordInfo) {
		int begin = 0;
		int end = AREA_LENGTH;
		return recordInfo.fullNumber.substring(begin, end);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
