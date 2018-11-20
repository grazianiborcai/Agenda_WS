package br.com.gda.business.phone.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

final class PhoneSetterAreaT01 implements InfoSetter<PhoneInfo> {
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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
