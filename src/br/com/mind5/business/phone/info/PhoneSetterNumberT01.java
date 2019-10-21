package br.com.mind5.business.phone.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PhoneSetterNumberT01 implements InfoSetter<PhoneInfo> {
	
	public PhoneInfo setAttr(PhoneInfo recordInfo) {
		checkArgument(recordInfo);
		
		if (hasArea(recordInfo) == false)
			recordInfo = setArea(recordInfo);
		
		return setNumber(recordInfo);
	}
	
		
	
	private void checkArgument(PhoneInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private boolean hasArea(PhoneInfo recordInfo) {
		return (recordInfo.codArea != null);
	}
	
	
	
	private PhoneInfo setArea(PhoneInfo recordInfo) {
		PhoneSetterAreaT01 setter = new PhoneSetterAreaT01();
		return setter.setAttr(recordInfo);
	}
	
	
	
	private PhoneInfo setNumber(PhoneInfo recordInfo) {
		recordInfo.number = recordInfo.fullNumber;
		
		if (hasArea(recordInfo)) {
			int begin = getAreaLength(recordInfo);
			int end = recordInfo.fullNumber.length();
			
			recordInfo.number = recordInfo.fullNumber.substring(begin, end);
		}		
		
		return recordInfo;
	}	
	
	
	
	private int getAreaLength(PhoneInfo recordInfo) {
		return recordInfo.codArea.length();
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
