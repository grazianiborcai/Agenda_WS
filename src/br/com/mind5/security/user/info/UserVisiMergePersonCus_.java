package br.com.mind5.security.user.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.personCustomer.info.PersonCusInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.security.user.info.UserInfo;

final class UserVisiMergePersonCus_ implements InfoMergerVisitor<UserInfo, PersonCusInfo> {

	@Override public UserInfo writeRecord(PersonCusInfo sourceOne, UserInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UserInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PersonCusInfo sourceOne, UserInfo sourceTwo) {
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
	
	
	
	private UserInfo merge(PersonCusInfo sourceOne, UserInfo sourceTwo) {
		sourceTwo.codCustomer = sourceOne.codCustomer;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(PersonCusInfo sourceOne, UserInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
