package br.com.mind5.security.user.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.common.AuthGroup;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class UserSetterAuthOwner implements InfoSetter<UserInfo> {
	
	public UserInfo setAttr(UserInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodAuthGrRole(recordInfo);
	}
	
	
	
	private void checkArgument(UserInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private UserInfo setCodAuthGrRole(UserInfo recordInfo) {
		recordInfo.codAuthGroup = AuthGroup.OWNER.getCodAuthGroup();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
