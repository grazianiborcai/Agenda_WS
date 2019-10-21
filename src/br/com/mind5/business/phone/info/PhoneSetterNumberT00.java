package br.com.mind5.business.phone.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PhoneSetterNumberT00 implements InfoSetter<PhoneInfo> {
	
	public PhoneInfo setAttr(PhoneInfo recordInfo) {
		checkArgument(recordInfo);		
		return setNumber(recordInfo);
	}
	
		
	
	private void checkArgument(PhoneInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PhoneInfo setNumber(PhoneInfo recordInfo) {
		recordInfo.number = recordInfo.fullNumber;
		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
