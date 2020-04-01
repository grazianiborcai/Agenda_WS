package br.com.mind5.business.customer.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CusSetterUserData implements InfoSetter<CusInfo> {
	
	public CusInfo setAttr(CusInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.codUser = recordInfo.userData.codUser;
		recordInfo.addresses = recordInfo.userData.addresses;
		recordInfo.phones = recordInfo.userData.phones;
		recordInfo.personData = recordInfo.userData.personData;
		
		return recordInfo;
	}
	
	
	
	private void checkArgument(CusInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}	
}
