package br.com.gda.business.user.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.obsolete.InfoKeeperVisitor_;

final class UserVisiKeepUser implements InfoKeeperVisitor_<UserInfo, UserInfo> {

	@Override public UserInfo keepAtribute(UserInfo sourceOne, UserInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UserInfo clonedInfo = makeClone(sourceTwo);
		return keep(sourceOne, clonedInfo);
	}
	
	
	
	private UserInfo makeClone(UserInfo recordInfo) {
		try {
			return (UserInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	private void checkArgument(UserInfo sourceOne, UserInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.KEEP_NOT_ALLOWED);
	}
	
	
	
	private UserInfo keep(UserInfo sourceOne, UserInfo sourceTwo) {
		sourceTwo.codOwner = sourceOne.codOwner;
		sourceTwo.codPerson = sourceOne.codPerson;
		sourceTwo.username = sourceOne.username;
		sourceTwo.codUserCategory = sourceOne.codUserCategory;
		sourceTwo.codLanguage = sourceOne.codLanguage;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(UserInfo sourceOne, UserInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
