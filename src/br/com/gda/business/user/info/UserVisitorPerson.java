package br.com.gda.business.user.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class UserVisitorPerson implements InfoMergerVisitor<UserInfo, PersonInfo, UserInfo> {

	@Override public UserInfo writeRecord(PersonInfo sourceOne, UserInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UserInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PersonInfo sourceOne, UserInfo sourceTwo) {
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
	
	
	
	private UserInfo merge(PersonInfo sourceOne, UserInfo sourceTwo) {
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
	
	
	
	@Override public boolean shouldWrite(PersonInfo sourceOne, UserInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
