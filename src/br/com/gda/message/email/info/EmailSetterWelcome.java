package br.com.gda.message.email.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.common.EmailBody;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class EmailSetterWelcome implements InfoSetter<EmailInfo> {
	
	public EmailInfo setAttr(EmailInfo recordInfo) {
		checkArgument(recordInfo);
		return setWelcome(recordInfo);
	}
	
	
	
	private void checkArgument(EmailInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private EmailInfo setWelcome(EmailInfo recordInfo) {
		EmailInfo result = makeClone(recordInfo);		
		result.bodyData.codBody = EmailBody.WELCOME.getCodBody();		
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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
