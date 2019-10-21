package br.com.mind5.business.storeWorkTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class StowotmVisiMergeStolis implements InfoMergerVisitor<StowotmInfo, StolisInfo> {

	@Override public StowotmInfo writeRecord(StolisInfo sourceOne, StowotmInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StowotmInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(StolisInfo sourceOne, StowotmInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StowotmInfo makeClone(StowotmInfo recordInfo) {
		try {
			return (StowotmInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private StowotmInfo merge(StolisInfo sourceOne, StowotmInfo sourceTwo) {
		sourceTwo.codTimezone = sourceOne.codTimezone;
		
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(StolisInfo sourceOne, StowotmInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner &&
				sourceOne.codStore == sourceTwo.codStore	);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
