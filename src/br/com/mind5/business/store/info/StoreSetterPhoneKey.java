package br.com.mind5.business.store.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class StoreSetterPhoneKey implements InfoSetter<StoreInfo> {
	
	public StoreInfo setAttr(StoreInfo recordInfo) {
		checkArgument(recordInfo);
		return setPhoneKey(recordInfo);
	}
	
	
	
	private void checkArgument(StoreInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private StoreInfo setPhoneKey(StoreInfo recordInfo) {
		for (PhoneInfo eachPhone : recordInfo.phones) {
			eachPhone.codOwner = recordInfo.codOwner;
			eachPhone.codStore = recordInfo.codStore;
			eachPhone.username = recordInfo.username;
			eachPhone.codLanguage = recordInfo.codLanguage;
		}
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
