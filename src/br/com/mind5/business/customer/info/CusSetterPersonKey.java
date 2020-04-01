package br.com.mind5.business.customer.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CusSetterPersonKey implements InfoSetter<CusInfo> {
	
	public CusInfo setAttr(CusInfo recordInfo) {
		checkArgument(recordInfo);
		return setPersonKey(recordInfo);
	}
	
	
	
	private void checkArgument(CusInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfo.personData == null) {
			logException(new NullPointerException("recordInfo.personData" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo.personData" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CusInfo setPersonKey(CusInfo recordInfo) {
		recordInfo.personData.codOwner = recordInfo.codOwner;
		recordInfo.personData.codPerson = recordInfo.codPerson;
		recordInfo.personData.username = recordInfo.username;
		recordInfo.personData.codLanguage = recordInfo.codLanguage;
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}	
}
