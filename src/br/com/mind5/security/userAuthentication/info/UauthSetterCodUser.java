package br.com.mind5.security.userAuthentication.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class UauthSetterCodUser implements InfoSetter<UauthInfo> {
	
	public UauthInfo setAttr(UauthInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodUser(recordInfo);
	}
	
	
	
	private void checkArgument(UauthInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private UauthInfo setCodUser(UauthInfo recordInfo) {
		recordInfo.codUser = DefaultValue.number();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
