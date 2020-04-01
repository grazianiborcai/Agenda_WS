package br.com.mind5.message.email.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmailVisiMergeToSelect implements InfoMergerVisitor_<EmailInfo, EmailInfo> {

	@Override public EmailInfo writeRecord(EmailInfo sourceOne, EmailInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(EmailInfo sourceOne, EmailInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmailInfo merge(EmailInfo sourceOne, EmailInfo sourceTwo) {
		EmailInfo result = makeClone(sourceTwo);		
		result.senderAddr = sourceOne.senderAddr;
		result.senderPass = sourceOne.senderPass;
		result.smtpHostname = sourceOne.smtpHostname;
		result.smtpPort = sourceOne.smtpPort;
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
	
	
	
	@Override public boolean shouldWrite(EmailInfo sourceOne, EmailInfo sourceTwo) {		
		return true;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
