package br.com.mind5.business.store.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class StoreSetterOwnerKey implements InfoSetter<StoreInfo> {
	
	public StoreInfo setAttr(StoreInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(StoreInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private StoreInfo setKey(StoreInfo recordInfo) {
		StoreInfo result = new StoreInfo();
		result.codOwner = recordInfo.codOwner;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		return result;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
