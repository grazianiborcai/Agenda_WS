package br.com.mind5.business.personUser_.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.user.info.UserInfo;

final class PersonUserVisiMergeUser implements InfoMergerVisitor_<PersonUserInfo, UserInfo, PersonUserInfo> {

	@Override public PersonUserInfo writeRecord(UserInfo sourceOne, PersonUserInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PersonUserInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UserInfo sourceOne, PersonUserInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PersonUserInfo makeClone(PersonUserInfo recordInfo) {
		try {
			return (PersonUserInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PersonUserInfo merge(UserInfo sourceOne, PersonUserInfo sourceTwo) {
		sourceTwo.userData = sourceOne;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(UserInfo sourceOne, PersonUserInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner 	&& 
				sourceOne.codPerson == sourceTwo.codPerson	&&
				sourceOne.codUser   == sourceTwo.codUser		);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
