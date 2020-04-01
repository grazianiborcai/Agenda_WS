package br.com.mind5.business.scheduleRange.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedageVisiMergeToSelect implements InfoMergerVisitor_<SchedageInfo, SchedageInfo> {

	@Override public SchedageInfo writeRecord(SchedageInfo sourceOne, SchedageInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(SchedageInfo sourceOne, SchedageInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private SchedageInfo merge(SchedageInfo sourceOne, SchedageInfo sourceTwo) {
		SchedageInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		result.dateValidFrom = sourceTwo.dateValidFrom;
		result.dateValidTo = sourceTwo.dateValidTo;
		result.timeValidFrom = sourceTwo.timeValidFrom;
		result.timeValidTo = sourceTwo.timeValidTo;
		return result;
	}
	
	
	
	private SchedageInfo makeClone(SchedageInfo recordInfo) {
		try {
			return (SchedageInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(SchedageInfo sourceOne, SchedageInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
