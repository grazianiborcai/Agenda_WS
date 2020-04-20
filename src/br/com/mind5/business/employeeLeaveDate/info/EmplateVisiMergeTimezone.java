package br.com.mind5.business.employeeLeaveDate.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;

final class EmplateVisiMergeTimezone implements InfoMergerVisitor_<EmplateInfo, TimezoneInfo> {

	@Override public EmplateInfo writeRecord(TimezoneInfo sourceOne, EmplateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmplateInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(TimezoneInfo sourceOne, EmplateInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmplateInfo makeClone(EmplateInfo recordInfo) {
		try {
			return (EmplateInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmplateInfo merge(TimezoneInfo sourceOne, EmplateInfo sourceTwo) {
		sourceTwo.txtTimezone = sourceOne.txtTimezone;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(TimezoneInfo sourceOne, EmplateInfo sourceTwo) {		
		return (sourceOne.codTimezone.equals(sourceTwo.codTimezone)	&&
				sourceOne.codLanguage.equals(sourceTwo.codLanguage)		);
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
