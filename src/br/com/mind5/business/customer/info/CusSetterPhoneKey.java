package br.com.mind5.business.customer.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CusSetterPhoneKey implements InfoSetter<CusInfo> {
	
	public CusInfo setAttr(CusInfo recordInfo) {
		checkArgument(recordInfo);
		return setPhoneKey(recordInfo);
	}
	
	
	
	private void checkArgument(CusInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CusInfo setPhoneKey(CusInfo recordInfo) {
		for (PhoneInfo eachRecord : recordInfo.phones) {
			eachRecord.codOwner = recordInfo.codOwner;
			eachRecord.codCustomer = recordInfo.codCustomer;
			eachRecord.codStore = DefaultValue.number();
			eachRecord.codEmployee = DefaultValue.number();
			eachRecord.codUser = DefaultValue.number();
			eachRecord.codOwnerRef = DefaultValue.number();
			eachRecord.codLanguage = recordInfo.codLanguage;
			eachRecord.username = recordInfo.username;
		}
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}	
}
