package br.com.gda.business.planningTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class PlanimeVisiMergeWeekday implements InfoMergerVisitorV2<PlanimeInfo, WeekdayInfo> {

	@Override public PlanimeInfo writeRecord(WeekdayInfo sourceOne, PlanimeInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
				
		WeekdayInfo clonedWeekday = makeClone(sourceOne);
		sourceTwo.weekdays.add(clonedWeekday);
		
		return sourceTwo;
	}
	
	
	
	private void checkArgument(WeekdayInfo sourceOne, PlanimeInfo sourceTwo) {		
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private WeekdayInfo makeClone(WeekdayInfo weekday) {
		try {
			return (WeekdayInfo) weekday.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(WeekdayInfo sourceOne, PlanimeInfo sourceTwo) {
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
