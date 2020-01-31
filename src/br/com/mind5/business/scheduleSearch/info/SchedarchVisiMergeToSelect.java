package br.com.mind5.business.scheduleSearch.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedarchVisiMergeToSelect implements InfoMergerVisitor_<SchedarchInfo, SchedarchInfo> {

	@Override public SchedarchInfo writeRecord(SchedarchInfo sourceOne, SchedarchInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(SchedarchInfo sourceOne, SchedarchInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private SchedarchInfo merge(SchedarchInfo sourceOne, SchedarchInfo sourceTwo) {
		SchedarchInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private SchedarchInfo makeClone(SchedarchInfo recordInfo) {
		try {
			return (SchedarchInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(SchedarchInfo sourceOne, SchedarchInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
