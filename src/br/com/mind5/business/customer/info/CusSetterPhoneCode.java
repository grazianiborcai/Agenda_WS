package br.com.mind5.business.customer.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CusSetterPhoneCode implements InfoSetter<CusInfo> {
	
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
			eachRecord.codPhone = DefaultValue.number();
		}
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}	
}
