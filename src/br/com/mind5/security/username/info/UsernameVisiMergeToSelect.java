package br.com.mind5.security.username.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UsernameVisiMergeToSelect implements InfoMergerVisitor_<UsernameInfo, UsernameInfo> {

	@Override public UsernameInfo writeRecord(UsernameInfo sourceOne, UsernameInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(UsernameInfo sourceOne, UsernameInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UsernameInfo merge(UsernameInfo sourceOne, UsernameInfo sourceTwo) {
		UsernameInfo result = makeClone(sourceOne);		
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private UsernameInfo makeClone(UsernameInfo recordInfo) {
		try {
			return (UsernameInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(UsernameInfo sourceOne, UsernameInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
