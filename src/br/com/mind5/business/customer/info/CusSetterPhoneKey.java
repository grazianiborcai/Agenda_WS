package br.com.mind5.business.customer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CusSetterPhoneKey implements InfoSetter<CusInfo> {
	
	public CusInfo setAttr(CusInfo recordInfo) {
		checkArgument(recordInfo);
		return setAddressKey(recordInfo);
	}
	
	
	
	private void checkArgument(CusInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CusInfo setAddressKey(CusInfo recordInfo) {
		for (PhoneInfo eachAddress : recordInfo.phones) {
			eachAddress.codOwner = recordInfo.codOwner;
			eachAddress.codCustomer = recordInfo.codCustomer;
			eachAddress.codLanguage = recordInfo.codLanguage;
			eachAddress.lastChangedBy = recordInfo.lastChangedBy;
		}
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
