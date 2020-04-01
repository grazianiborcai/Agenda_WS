package br.com.mind5.message.emailBody.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.message.email.info.EmailInfo;

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
		
		SystemLog.logError(this.getClass(), e);
	}
}
