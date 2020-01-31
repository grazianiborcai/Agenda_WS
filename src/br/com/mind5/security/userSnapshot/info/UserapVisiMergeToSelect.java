package br.com.mind5.security.userSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UserapVisiMergeToSelect implements InfoMergerVisitor_<UserapInfo, UserapInfo> {

	@Override public UserapInfo writeRecord(UserapInfo sourceOne, UserapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(UserapInfo sourceOne, UserapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UserapInfo merge(UserapInfo sourceOne, UserapInfo sourceTwo) {
		UserapInfo result = makeClone(sourceOne);		
		result.codLanguage = sourceTwo.codLanguage;
		result.username = sourceTwo.username;
		return result;
	}
	
	
	
	private UserapInfo makeClone(UserapInfo recordInfo) {
		try {
			return (UserapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(UserapInfo sourceOne, UserapInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
