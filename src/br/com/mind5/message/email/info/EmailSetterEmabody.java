package br.com.mind5.message.email.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class EmailSetterEmabody implements InfoSetter<EmailInfo> {
	
	public EmailInfo setAttr(EmailInfo recordInfo) {
		checkArgument(recordInfo);
		return setEmabody(recordInfo);
	}
	
	
	
	private void checkArgument(EmailInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private EmailInfo setEmabody(EmailInfo recordInfo) {
		EmailInfo result = makeClone(recordInfo);		
		result.bodyData.codLanguage = recordInfo.codLanguage;		
		result.bodyData.username = recordInfo.username;	
		return result;
	}
	
	
	
	private EmailInfo makeClone(EmailInfo recordInfo) {
		try {
			return (EmailInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
