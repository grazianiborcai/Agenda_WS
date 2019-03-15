package br.com.gda.business.storeTime_.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class StorimeVisiMergeStowotm implements InfoMergerVisitor<StorimeInfo, StowotmInfo, StorimeInfo> {

	@Override public StorimeInfo writeRecord(StowotmInfo sourceOne, StorimeInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StorimeInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(StowotmInfo sourceOne, StorimeInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StorimeInfo makeClone(StorimeInfo recordInfo) {
		try {
			return (StorimeInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private StorimeInfo merge(StowotmInfo sourceOne, StorimeInfo sourceTwo) {
		sourceTwo.stowotms.add(sourceOne);

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(StowotmInfo sourceOne, StorimeInfo sourceTwo) {
		return (sourceOne.codOwner 	== sourceTwo.codOwner 	&&
				sourceOne.codStore 	== sourceTwo.codStore		);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
