package br.com.mind5.business.storeWorkTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StowotmVisiMergeToUpdate implements InfoMergerVisitor_<StowotmInfo, StowotmInfo> {

	@Override public StowotmInfo writeRecord(StowotmInfo sourceOne, StowotmInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(StowotmInfo sourceOne, StowotmInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StowotmInfo merge(StowotmInfo sourceOne, StowotmInfo sourceTwo) {
		StowotmInfo result = makeClone(sourceOne);		
		result.beginTime = sourceTwo.beginTime;
		result.endTime = sourceTwo.endTime;
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private StowotmInfo makeClone(StowotmInfo recordInfo) {
		try {
			return (StowotmInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(StowotmInfo sourceOne, StowotmInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
