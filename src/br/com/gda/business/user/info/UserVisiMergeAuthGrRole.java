package br.com.gda.business.user.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class UserVisiMergeAuthGrRole implements InfoMergerVisitor<UserInfo, AuthGrRoleInfo, UserInfo> {

	@Override public UserInfo writeRecord(AuthGrRoleInfo sourceOne, UserInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UserInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(AuthGrRoleInfo sourceOne, UserInfo sourceTwo) {
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
	
	
	
	private UserInfo merge(AuthGrRoleInfo sourceOne, UserInfo sourceTwo) {
		sourceTwo.authGrRoles.add(makeClone(sourceOne));
		return sourceTwo;
	}
	
	
	
	private AuthGrRoleInfo makeClone(AuthGrRoleInfo recordInfo) {
		try {
			return (AuthGrRoleInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(AuthGrRoleInfo sourceOne, UserInfo sourceTwo) {
		return true;
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
