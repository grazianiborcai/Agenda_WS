package br.com.gda.business.user.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class UserSetterPhoneKey implements InfoSetter<UserInfo> {
	
	public UserInfo setAttr(UserInfo recordInfo) {
		checkArgument(recordInfo);
		return setAddressKey(recordInfo);
	}
	
	
	
	private void checkArgument(UserInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private UserInfo setAddressKey(UserInfo recordInfo) {
		for (PhoneInfo eachAddress : recordInfo.phones) {
			eachAddress.codOwner = recordInfo.codOwner;
			eachAddress.codCustomer = recordInfo.codUser;
		}
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
