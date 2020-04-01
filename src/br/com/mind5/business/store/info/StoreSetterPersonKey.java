package br.com.mind5.business.store.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class StoreSetterPersonKey implements InfoSetter<StoreInfo> {
	
	public StoreInfo setAttr(StoreInfo recordInfo) {
		checkArgument(recordInfo);
		return setPersonKey(recordInfo);
	}
	
	
	
	private void checkArgument(StoreInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfo.personData == null) {
			logException(new NullPointerException("recordInfo.personData" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo.personData" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private StoreInfo setPersonKey(StoreInfo recordInfo) {
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
