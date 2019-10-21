package br.com.mind5.business.person.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class PersonVisiMergePersonap implements InfoMergerVisitor<PersonInfo, PersonapInfo> {

	@Override public PersonInfo writeRecord(PersonapInfo sourceOne, PersonInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PersonInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PersonapInfo sourceOne, PersonInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PersonInfo makeClone(PersonInfo recordInfo) {
		try {
			return (PersonInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PersonInfo merge(PersonapInfo sourceOne, PersonInfo sourceTwo) {
		sourceTwo.codSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(PersonapInfo sourceOne, PersonInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner	&&
				sourceOne.codPerson == sourceTwo.codPerson		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
