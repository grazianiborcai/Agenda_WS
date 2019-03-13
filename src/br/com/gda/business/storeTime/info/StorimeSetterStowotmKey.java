package br.com.gda.business.storeTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class StorimeSetterStowotmKey implements InfoSetter<StorimeInfo> {
	
	public StorimeInfo setAttr(StorimeInfo recordInfo) {
		checkArgument(recordInfo);
		return setStowotmKey(recordInfo);
	}
	
	
	
	private void checkArgument(StorimeInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private StorimeInfo setStowotmKey(StorimeInfo recordInfo) {
		for (StowotmInfo eachRecord : recordInfo.stowotms) {
			eachRecord.codOwner = recordInfo.codOwner;
			eachRecord.codStore = recordInfo.codStore;
			eachRecord.username = recordInfo.username;
			eachRecord.codLanguage = recordInfo.codLanguage;
		}
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
