package br.com.gda.business.storeSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class StoreSetterKey implements InfoSetter<StorapInfo> {
	
	public StorapInfo setAttr(StorapInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(StorapInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private StorapInfo setKey(StorapInfo recordInfo) {
		StorapInfo result = new StorapInfo();
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		return result;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
