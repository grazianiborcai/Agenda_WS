package br.com.mind5.business.personSnapshot.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.gender.info.GenderInfo;

final class PersonapVisiMergeGender implements InfoMergerVisitor_<PersonapInfo, GenderInfo> {

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
		
		SystemLog.logError(this.getClass(), e);
	}
}
