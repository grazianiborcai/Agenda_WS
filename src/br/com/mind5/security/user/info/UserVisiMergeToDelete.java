package br.com.mind5.security.user.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UserVisiMergeToDelete implements InfoMergerVisitor_<UserInfo, UserInfo> {

	@Override public UserInfo writeRecord(UserInfo sourceOne, UserInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(UserInfo sourceOne, UserInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UserInfo merge(UserInfo sourceOne, UserInfo sourceTwo) {
		UserInfo result = makeClone(sourceOne);		
		result.lastChangedBy = sourceTwo.lastChangedBy;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private UserInfo makeClone(UserInfo recordInfo) {
		try {
			return (UserInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(UserInfo sourceOne, UserInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner	&&
				sourceOne.codUser  == sourceTwo.codUser			);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
