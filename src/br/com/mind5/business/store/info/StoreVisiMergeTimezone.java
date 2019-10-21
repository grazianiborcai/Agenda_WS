package br.com.mind5.business.store.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class StoreVisiMergeTimezone implements InfoMergerVisitor<StoreInfo, TimezoneInfo> {

	@Override public StoreInfo writeRecord(TimezoneInfo sourceOne, StoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StoreInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(TimezoneInfo sourceOne, StoreInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StoreInfo makeClone(StoreInfo recordInfo) {
		try {
			return (StoreInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private StoreInfo merge(TimezoneInfo sourceOne, StoreInfo sourceTwo) {
		sourceTwo.txtTimezone = sourceOne.txtTimezone;

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(TimezoneInfo sourceOne, StoreInfo sourceTwo) {
		return (sourceOne.codTimezone.equals(sourceTwo.codTimezone));
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
