package br.com.gda.business.employeeWorkTimeOutlier.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

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
		sourceTwo.codWeekday = sourceOne.codWeekday;		
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(WeekdayInfo sourceOne, EmpwoutInfo sourceTwo) {
		if (sourceOne.codLanguage	==	null ||
			sourceTwo.codLanguage	==	null	)
			return false;
		
		return (sourceOne.codLanguage.equals(sourceTwo.codLanguage));
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
