package br.com.gda.security.userPassword.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.security.user.info.UserInfo;

final class UpswdVisiMergeUser implements InfoMergerVisitorV2<UpswdInfo, UserInfo> {

	@Override public UpswdInfo writeRecord(UserInfo sourceOne, UpswdInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UpswdInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UserInfo sourceOne, UpswdInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UpswdInfo makeClone(UpswdInfo recordInfo) {
		try {
			return (UpswdInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private UpswdInfo merge(UserInfo sourceOne, UpswdInfo sourceTwo) {
		sourceTwo.username = sourceOne.username;
		sourceTwo.codOwner = sourceOne.codOwner;
		sourceTwo.codUser = sourceOne.codUser;		
		sourceTwo.personData = makeClone(sourceOne.personData);
		return sourceTwo;
	}
	
	
	
	private PersonInfo makeClone(PersonInfo recordInfo) {
		try {
			return (PersonInfo) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e);
		}
	}
	
	
	
	@Override public boolean shouldWrite(UserInfo sourceOne, UpswdInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner 	&&
				//sourceOne.codUser  		== sourceTwo.codUser	&&
				sourceOne.personData 	!= null						);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
