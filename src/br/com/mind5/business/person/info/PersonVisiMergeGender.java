package br.com.mind5.business.person.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PersonVisiMergeGender implements InfoMergerVisitor_<PersonInfo, GenderInfo> {

	@Override public PersonInfo writeRecord(GenderInfo sourceOne, PersonInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PersonInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(GenderInfo sourceOne, PersonInfo sourceTwo) {
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
	
	
	
	private PersonInfo merge(GenderInfo sourceOne, PersonInfo sourceTwo) {
		sourceTwo.txtGender = sourceOne.txtGender;

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(GenderInfo sourceOne, PersonInfo sourceTwo) {
		return (sourceOne.codGender == sourceTwo.codGender);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
