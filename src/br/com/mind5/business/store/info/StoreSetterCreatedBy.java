package br.com.mind5.business.store.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class StoreSetterCreatedBy implements InfoSetter<StoreInfo> {
	
	public StoreInfo setAttr(StoreInfo recordInfo) {
		checkArgument(recordInfo);
		return setCreatedBy(recordInfo);
	}
	
	
	
	private void checkArgument(StoreInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private StoreInfo setCreatedBy(StoreInfo recordInfo) {
		recordInfo.createdBy = recordInfo.codUser;		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
