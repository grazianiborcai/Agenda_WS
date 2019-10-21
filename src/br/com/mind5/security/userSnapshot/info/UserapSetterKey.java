package br.com.mind5.security.userSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class UserapSetterKey implements InfoSetter<UserapInfo> {
	
	public UserapInfo setAttr(UserapInfo recordInfo) {
		checkArgument(recordInfo);
		return setUserKey(recordInfo);
	}
	
	
	
	private void checkArgument(UserapInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private UserapInfo setUserKey(UserapInfo recordInfo) {
		UserapInfo enforcedRecord = new UserapInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codSnapshot = recordInfo.codSnapshot;
		
		return enforcedRecord;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
