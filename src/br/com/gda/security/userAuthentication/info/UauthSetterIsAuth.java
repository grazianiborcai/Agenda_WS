package br.com.gda.security.userAuthentication.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class UauthSetterIsAuth implements InfoSetter<UauthInfo> {
	
	public UauthInfo setAttr(UauthInfo recordInfo) {
		checkArgument(recordInfo);
		return setIsAuth(recordInfo);
	}
	
	
	
	private void checkArgument(UauthInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private UauthInfo setIsAuth(UauthInfo recordInfo) {
		recordInfo.isAuth = true;
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
