package br.com.gda.security.storeAuthorization.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class StorauthSetterOwnerKey implements InfoSetter<StorauthInfo> {
	
	public StorauthInfo setAttr(StorauthInfo recordInfo) {
		checkArgument(recordInfo);
		return setCategOwnerKey(recordInfo);
	}
	
	
	
	private void checkArgument(StorauthInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private StorauthInfo setCategOwnerKey(StorauthInfo recordInfo) {
		recordInfo.codUser = DefaultValue.number();		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
