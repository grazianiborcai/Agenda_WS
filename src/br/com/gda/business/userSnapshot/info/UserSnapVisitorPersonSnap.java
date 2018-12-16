package br.com.gda.business.userSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class UserSnapVisitorPersonSnap implements InfoMergerVisitor<UserSnapInfo, PersonSnapInfo, UserSnapInfo> {

	@Override public UserSnapInfo writeRecord(PersonSnapInfo sourceOne, UserSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UserSnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PersonSnapInfo sourceOne, UserSnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UserSnapInfo makeClone(UserSnapInfo recordInfo) {
		try {
			return (UserSnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private UserSnapInfo merge(PersonSnapInfo sourceOne, UserSnapInfo sourceTwo) {
		sourceTwo.codPerson = sourceOne.codPerson;
		sourceTwo.cpf = sourceOne.cpf;
		sourceTwo.name = sourceOne.name;
		sourceTwo.codGender = sourceOne.codGender;
		sourceTwo.txtGender = sourceOne.txtGender;
		sourceTwo.codEntityCateg = sourceOne.codEntityCateg;
		sourceTwo.birthDate = sourceOne.birthDate;
		sourceTwo.email = sourceOne.email;

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(PersonSnapInfo sourceOne, UserSnapInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner 		&&
				sourceOne.codSnapshot 	== sourceTwo.codSnapshot		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
