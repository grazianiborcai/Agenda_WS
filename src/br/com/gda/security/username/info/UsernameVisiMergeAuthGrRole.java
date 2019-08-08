package br.com.gda.security.username.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class UsernameVisiMergeAuthGrRole implements InfoMergerVisitor<UsernameInfo, AuthGrRoleInfo> {

	@Override public UsernameInfo writeRecord(AuthGrRoleInfo sourceOne, UsernameInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UsernameInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(AuthGrRoleInfo sourceOne, UsernameInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UsernameInfo makeClone(UsernameInfo recordInfo) {
		try {
			return (UsernameInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private UsernameInfo merge(AuthGrRoleInfo sourceOne, UsernameInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(AuthGrRoleInfo sourceOne, UsernameInfo sourceTwo) {
		return true;
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
