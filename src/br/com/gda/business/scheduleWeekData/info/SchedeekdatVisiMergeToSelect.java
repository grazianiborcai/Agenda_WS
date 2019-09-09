package br.com.gda.business.scheduleWeekData.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class SchedeekdatVisiMergeToSelect implements InfoMergerVisitor<SchedeekdatInfo, SchedeekdatInfo> {

	@Override public SchedeekdatInfo writeRecord(SchedeekdatInfo sourceOne, SchedeekdatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(SchedeekdatInfo sourceOne, SchedeekdatInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private SchedeekdatInfo merge(SchedeekdatInfo sourceOne, SchedeekdatInfo sourceTwo) {
		SchedeekdatInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private SchedeekdatInfo makeClone(SchedeekdatInfo recordInfo) {
		try {
			return (SchedeekdatInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(SchedeekdatInfo sourceOne, SchedeekdatInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
