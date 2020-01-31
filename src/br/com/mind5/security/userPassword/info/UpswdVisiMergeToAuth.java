package br.com.mind5.security.userPassword.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UpswdVisiMergeToAuth implements InfoMergerVisitor_<UpswdInfo, UpswdInfo> {

	@Override public UpswdInfo writeRecord(UpswdInfo sourceOne, UpswdInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(UpswdInfo sourceOne, UpswdInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UpswdInfo merge(UpswdInfo sourceOne, UpswdInfo sourceTwo) {
		UpswdInfo result = makeClone(sourceOne);		
		result.codLanguage = sourceTwo.codLanguage;
		result.password = sourceTwo.password;
		return result;
	}
	
	
	
	private UpswdInfo makeClone(UpswdInfo recordInfo) {
		try {
			return (UpswdInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(UpswdInfo sourceOne, UpswdInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
