package br.com.mind5.business.employeeWorkTimeOutlier.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class EmpwoutVisiMergeWeekday implements InfoMergerVisitor<EmpwoutInfo, WeekdayInfo> {

	@Override public EmpwoutInfo writeRecord(WeekdayInfo sourceOne, EmpwoutInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpwoutInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(WeekdayInfo sourceOne, EmpwoutInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpwoutInfo makeClone(EmpwoutInfo recordInfo) {
		try {
			return (EmpwoutInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmpwoutInfo merge(WeekdayInfo sourceOne, EmpwoutInfo sourceTwo) {
		sourceTwo.txtWeekday = sourceOne.txtWeekday;		
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(WeekdayInfo sourceOne, EmpwoutInfo sourceTwo) {
		return (sourceOne.codWeekday == sourceTwo.codWeekday);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
