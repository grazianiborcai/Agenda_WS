package br.com.mind5.business.storeWorkTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class StowotmVisiMergeStowotarch implements InfoMergerVisitor<StowotmInfo, StowotarchInfo> {

	@Override public StowotmInfo writeRecord(StowotarchInfo sourceOne, StowotmInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StowotmInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(StowotarchInfo sourceOne, StowotmInfo sourceTwo) {
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
	
	
	
	private StowotmInfo merge(StowotarchInfo sourceOne, StowotmInfo sourceTwo) {
		return StowotmInfo.copyFrom(sourceOne);
	}
	
	
	
	@Override public boolean shouldWrite(StowotarchInfo sourceOne, StowotmInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
