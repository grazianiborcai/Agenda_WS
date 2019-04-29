package br.com.gda.business.employeeList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class EmplisVisiMergePerson implements InfoMergerVisitorV2<EmplisInfo, PersonInfo> {

	@Override public EmplisInfo writeRecord(PersonInfo sourceOne, EmplisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmplisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PersonInfo sourceOne, EmplisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmplisInfo makeClone(EmplisInfo recordInfo) {
		try {
			return (EmplisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmplisInfo merge(PersonInfo sourceOne, EmplisInfo sourceTwo) {
		sourceTwo.personData = new PersonInfo();
		
		sourceTwo.personData.name = sourceOne.name;
		sourceTwo.personData.codPerson = sourceOne.codPerson;
		sourceTwo.personData.codGender = sourceOne.codGender;
		sourceTwo.personData.txtGender = sourceOne.txtGender;
		sourceTwo.personData.codLanguage = sourceOne.codLanguage;

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(PersonInfo sourceOne, EmplisInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
