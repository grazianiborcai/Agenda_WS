package br.com.gda.business.person.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PersonVisiMergeToDelete implements InfoMergerVisitor<PersonInfo, PersonInfo, PersonInfo> {

	@Override public PersonInfo writeRecord(PersonInfo sourceOne, PersonInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(PersonInfo sourceOne, PersonInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PersonInfo merge(PersonInfo sourceOne, PersonInfo sourceTwo) {
		PersonInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private PersonInfo makeClone(PersonInfo recordInfo) {
		try {
			return (PersonInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(PersonInfo sourceOne, PersonInfo sourceTwo) {		
		return (sourceOne.codOwner  == sourceTwo.codOwner 	&&
				sourceOne.codPerson == sourceTwo.codPerson		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
