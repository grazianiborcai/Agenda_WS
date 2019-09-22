package br.com.gda.business.store.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
