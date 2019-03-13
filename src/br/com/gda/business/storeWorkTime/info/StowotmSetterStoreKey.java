package br.com.gda.business.storeWorkTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class StowotmSetterStoreKey implements InfoSetter<StowotmInfo> {
	
	public StowotmInfo setAttr(StowotmInfo recordInfo) {
		checkArgument(recordInfo);
		return setStoreKey(recordInfo);
	}
	
	
	
	private void checkArgument(StowotmInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private StowotmInfo setStoreKey(StowotmInfo recordInfo) {
		StowotmInfo result = new StowotmInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;

		return result;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
