package br.com.gda.security.userPassword.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.obsolete.InfoKeeperVisitor_;

final class UpswdVisiKeepUpswd implements InfoKeeperVisitor_<UpswdInfo, UpswdInfo> {

	@Override public UpswdInfo keepAtribute(UpswdInfo sourceOne, UpswdInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UpswdInfo clonedInfo = makeClone(sourceOne);
		return keep(clonedInfo, sourceTwo);
	}
	
	
	
	private UpswdInfo makeClone(UpswdInfo recordInfo) {
		try {
			return (UpswdInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	private void checkArgument(UpswdInfo sourceOne, UpswdInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.KEEP_NOT_ALLOWED);
	}
	
	
	
	private UpswdInfo keep(UpswdInfo sourceOne, UpswdInfo sourceTwo) {
		sourceOne.password = sourceTwo.password;
		return sourceOne;
	}
	
	
	
	@Override public boolean shouldWrite(UpswdInfo sourceOne, UpswdInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner	&&
				sourceOne.codUser == sourceTwo.codUser			);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
