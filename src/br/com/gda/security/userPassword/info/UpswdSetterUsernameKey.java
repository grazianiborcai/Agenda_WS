package br.com.gda.security.userPassword.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class UpswdSetterUsernameKey implements InfoSetter<UpswdInfo> {
	
	public UpswdInfo setAttr(UpswdInfo recordInfo) {
		checkArgument(recordInfo);
		return setUsernameKey(recordInfo);
	}
	
	
	
	private void checkArgument(UpswdInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private UpswdInfo setUsernameKey(UpswdInfo recordInfo) {
		UpswdInfo clonedInfo = makeClone(recordInfo);
		clonedInfo.codUser = DefaultValue.number();
		return clonedInfo;
	}
	
	
	
	private UpswdInfo makeClone(UpswdInfo recordInfo) {
		try {
			return (UpswdInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
