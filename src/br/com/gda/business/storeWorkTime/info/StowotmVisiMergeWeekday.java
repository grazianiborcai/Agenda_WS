package br.com.gda.business.storeWorkTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class StowotmVisiMergeWeekday implements InfoMergerVisitor<StowotmInfo, WeekdayInfo> {

	@Override public StowotmInfo writeRecord(WeekdayInfo sourceOne, StowotmInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StowotmInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(WeekdayInfo sourceOne, StowotmInfo sourceTwo) {
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
	
	
	
	private StowotmInfo merge(WeekdayInfo sourceOne, StowotmInfo sourceTwo) {
		sourceTwo.txtWeekday = sourceOne.txtWeekday;		
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(WeekdayInfo sourceOne, StowotmInfo sourceTwo) {
		return (sourceOne.codWeekday == sourceTwo.codWeekday);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
