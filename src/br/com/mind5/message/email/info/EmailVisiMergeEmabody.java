package br.com.mind5.message.email.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

final class EmailVisiMergeEmabody implements InfoMergerVisitor_<EmailInfo, EmabodyInfo> {

	@Override public EmailInfo writeRecord(EmabodyInfo sourceOne, EmailInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(EmabodyInfo sourceOne, EmailInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmailInfo merge(EmabodyInfo sourceOne, EmailInfo sourceTwo) {
		EmailInfo resultInfo = makeClone(sourceTwo);
		resultInfo.bodyData = makeClone(sourceOne);
		
		return resultInfo;
	}
	
	
	
	private EmailInfo makeClone(EmailInfo recordInfo) {
		try {
			return (EmailInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmabodyInfo makeClone(EmabodyInfo recordInfo) {
		try {
			return (EmabodyInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(EmabodyInfo sourceOne, EmailInfo sourceTwo) {
		return true;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
