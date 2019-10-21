package br.com.mind5.security.user.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.common.UserCateg;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class UserSetterCategStore implements InfoSetter<UserInfo> {
	
	public UserInfo setAttr(UserInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodUserCateg(recordInfo);
	}
	
	
	
	private void checkArgument(UserInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private UserInfo setCodUserCateg(UserInfo recordInfo) {
		recordInfo.codUserCategory = UserCateg.STORE.getCodUserCateg();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
