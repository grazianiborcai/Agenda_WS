package br.com.mind5.security.storeAuthorization.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

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
		
		SystemLog.logError(this.getClass(), e);
	}	
}
