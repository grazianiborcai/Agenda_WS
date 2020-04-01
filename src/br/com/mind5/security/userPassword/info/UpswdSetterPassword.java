package br.com.mind5.security.userPassword.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class UpswdSetterPassword implements InfoSetter<UpswdInfo> {
	
	public UpswdInfo setAttr(UpswdInfo recordInfo) {
		checkArgument(recordInfo);
		return setLength(recordInfo);
	}
	
	
	
	private void checkArgument(UpswdInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfo.passwordToChange == null) {
			logException(new NullPointerException("recordInfo.passwordToChange" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo.passwordToChange" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private UpswdInfo setLength(UpswdInfo recordInfo) {
		recordInfo.password = recordInfo.passwordToChange;
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
