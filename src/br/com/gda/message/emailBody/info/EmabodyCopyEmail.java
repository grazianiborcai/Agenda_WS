package br.com.gda.message.emailBody.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.message.email.info.EmailInfo;

final class EmabodyCopyEmail extends InfoCopierTemplate<EmabodyInfo, EmailInfo>{
	
	public EmabodyCopyEmail() {
		super();
	} 
	
	
	
	@Override protected EmabodyInfo makeCopyHook(EmailInfo source) {
		return makeClone(source.bodyData);
	}
	
	
	
	private EmabodyInfo makeClone(EmabodyInfo recordInfo) {
		try {
			return (EmabodyInfo) recordInfo.clone();
			
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
