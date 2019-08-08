package br.com.gda.security.user.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class UserVisiMergeToUpdate implements InfoMergerVisitor<UserInfo, UserInfo> {

	@Override public UserInfo writeRecord(UserInfo sourceOne, UserInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(UserInfo sourceOne, UserInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UserInfo merge(UserInfo sourceOne, UserInfo sourceTwo) {
		UserInfo result = makeClone(sourceTwo);	
		result.codPerson = sourceOne.codPerson;
		result.username = sourceOne.username;
		result.codSnapshot = sourceOne.codSnapshot;
		result.codUserCategory = sourceOne.codUserCategory;
		result.codAuthGroup = sourceOne.codAuthGroup;
		result.codLanguage = sourceOne.codLanguage;
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
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
