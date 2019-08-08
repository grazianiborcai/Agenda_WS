package br.com.gda.security.user.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.security.userSnapshot.info.UserapInfo;

final class UserVisiMergeUserap implements InfoMergerVisitor<UserInfo, UserapInfo> {

	@Override public UserInfo writeRecord(UserapInfo sourceOne, UserInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UserInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UserapInfo sourceOne, UserInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UserInfo makeClone(UserInfo recordInfo) {
		try {
			return (UserInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private UserInfo merge(UserapInfo sourceOne, UserInfo sourceTwo) {
		sourceTwo.codSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(UserapInfo sourceOne, UserInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner && 
				sourceOne.codUser  == sourceTwo.codUser		);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
