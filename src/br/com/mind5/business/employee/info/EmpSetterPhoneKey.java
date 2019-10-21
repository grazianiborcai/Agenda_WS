package br.com.mind5.business.employee.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class EmpSetterPhoneKey implements InfoSetter<EmpInfo> {
	
	public EmpInfo setAttr(EmpInfo recordInfo) {
		checkArgument(recordInfo);
		return setPhoneKey(recordInfo);
	}
	
	
	
	private void checkArgument(EmpInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private EmpInfo setPhoneKey(EmpInfo recordInfo) {
		for (PhoneInfo eachPhone : recordInfo.phones) {
			eachPhone.codOwner = recordInfo.codOwner;
			eachPhone.codEmployee = recordInfo.codEmployee;
			eachPhone.codLanguage = recordInfo.codLanguage;
			eachPhone.username = recordInfo.username;
		}
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
