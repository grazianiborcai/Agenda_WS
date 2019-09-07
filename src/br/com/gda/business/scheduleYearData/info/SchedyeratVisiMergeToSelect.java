package br.com.gda.business.scheduleYearData.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class SchedyeratVisiMergeToSelect implements InfoMergerVisitor<SchedyeratInfo, SchedyeratInfo> {

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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
