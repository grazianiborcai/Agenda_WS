package br.com.mind5.business.scheduleYearData.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedyeratVisiMergeToSelect implements InfoMergerVisitor_<SchedyeratInfo, SchedyeratInfo> {

	@Override public SchedyeratInfo writeRecord(SchedyeratInfo sourceOne, SchedyeratInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(SchedyeratInfo sourceOne, SchedyeratInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private SchedyeratInfo merge(SchedyeratInfo sourceOne, SchedyeratInfo sourceTwo) {
		SchedyeratInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private SchedyeratInfo makeClone(SchedyeratInfo recordInfo) {
		try {
			return (SchedyeratInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(SchedyeratInfo sourceOne, SchedyeratInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
