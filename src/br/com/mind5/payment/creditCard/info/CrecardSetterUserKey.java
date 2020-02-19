package br.com.mind5.payment.creditCard.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CrecardSetterUserKey implements InfoSetter<CrecardInfo> {
	
	public CrecardInfo setAttr(CrecardInfo recordInfo) {
		checkArgument(recordInfo);
		
		CrecardInfo result = new CrecardInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codUser = recordInfo.codUser;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;

		return result;
	}
	
	
	
	private void checkArgument(CrecardInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
