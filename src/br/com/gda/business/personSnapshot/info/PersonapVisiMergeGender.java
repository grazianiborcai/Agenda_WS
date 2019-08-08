package br.com.gda.business.personSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PersonapVisiMergeGender implements InfoMergerVisitor<PersonapInfo, GenderInfo> {

	@Override public PersonapInfo writeRecord(GenderInfo sourceOne, PersonapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PersonapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(GenderInfo sourceOne, PersonapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PersonapInfo makeClone(PersonapInfo recordInfo) {
		try {
			return (PersonapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PersonapInfo merge(GenderInfo sourceOne, PersonapInfo sourceTwo) {
		sourceTwo.txtGender = sourceOne.txtGender;

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(GenderInfo sourceOne, PersonapInfo sourceTwo) {
		return (sourceOne.codGender == sourceTwo.codGender);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
