package br.com.gda.business.store.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.common.AuthGroup;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class StoreSetterCodAuthGroup implements InfoSetter<StoreInfo> {
	
	public StoreInfo setAttr(StoreInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodAuthGrRole(recordInfo);
	}
	
	
	
	private void checkArgument(StoreInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private StoreInfo setCodAuthGrRole(StoreInfo recordInfo) {
		recordInfo.codAuthGroup = AuthGroup.STORE_MANAGER.getCodAuthGroup();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
