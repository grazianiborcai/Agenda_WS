package br.com.mind5.business.scheduleMonthData.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedonthatVisiMergeToSelect implements InfoMergerVisitor_<SchedonthatInfo, SchedonthatInfo> {

	@Override public SchedonthatInfo writeRecord(SchedonthatInfo sourceOne, SchedonthatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(SchedonthatInfo sourceOne, SchedonthatInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private SchedonthatInfo merge(SchedonthatInfo sourceOne, SchedonthatInfo sourceTwo) {
		SchedonthatInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private SchedonthatInfo makeClone(SchedonthatInfo recordInfo) {
		try {
			return (SchedonthatInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(SchedonthatInfo sourceOne, SchedonthatInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
