package br.com.mind5.security.userSearch.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class UserarchVisiMergeToSelect implements InfoMergerVisitor<UserarchInfo, UserarchInfo> {

	@Override public UserarchInfo writeRecord(UserarchInfo sourceOne, UserarchInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(UserarchInfo sourceOne, UserarchInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UserarchInfo merge(UserarchInfo sourceOne, UserarchInfo sourceTwo) {
		UserarchInfo result = makeClone(sourceOne);		
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private UserarchInfo makeClone(UserarchInfo recordInfo) {
		try {
			return (UserarchInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(UserarchInfo sourceOne, UserarchInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
