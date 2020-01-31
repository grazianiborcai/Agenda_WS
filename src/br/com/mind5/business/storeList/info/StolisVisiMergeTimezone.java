package br.com.mind5.business.storeList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StolisVisiMergeTimezone implements InfoMergerVisitor_<StolisInfo, TimezoneInfo> {

	@Override public StolisInfo writeRecord(TimezoneInfo sourceOne, StolisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StolisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(TimezoneInfo sourceOne, StolisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StolisInfo makeClone(StolisInfo recordInfo) {
		try {
			return (StolisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private StolisInfo merge(TimezoneInfo sourceOne, StolisInfo sourceTwo) {
		sourceTwo.txtTimezone = sourceOne.txtTimezone;

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(TimezoneInfo sourceOne, StolisInfo sourceTwo) {
		return (sourceOne.codTimezone.equals(sourceTwo.codTimezone));
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
