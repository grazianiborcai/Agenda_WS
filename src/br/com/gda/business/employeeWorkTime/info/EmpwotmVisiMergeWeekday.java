package br.com.gda.business.employeeWorkTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class EmpwotmVisiMergeWeekday implements InfoMergerVisitor<EmpwotmInfo, WeekdayInfo, EmpwotmInfo> {

	@Override public EmpwotmInfo writeRecord(WeekdayInfo sourceOne, EmpwotmInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpwotmInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(WeekdayInfo sourceOne, EmpwotmInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpwotmInfo makeClone(EmpwotmInfo recordInfo) {
		try {
			return (EmpwotmInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmpwotmInfo merge(WeekdayInfo sourceOne, EmpwotmInfo sourceTwo) {
		sourceTwo.txtWeekday = sourceOne.txtWeekday;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(WeekdayInfo sourceOne, EmpwotmInfo sourceTwo) {		
		return (sourceOne.codWeekday == sourceTwo.codWeekday		&&
				sourceOne.codLanguage.equals(sourceTwo.codLanguage)		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
