package br.com.gda.business.employeeWorkTimeConflict.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor_;

final class EmpwocoVisiMergeWeekday_ implements InfoMergerVisitor_<EmpwocoInfo, WeekdayInfo, EmpwocoInfo> {

	@Override public EmpwocoInfo writeRecord(WeekdayInfo sourceOne, EmpwocoInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpwocoInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(WeekdayInfo sourceOne, EmpwocoInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpwocoInfo makeClone(EmpwocoInfo recordInfo) {
		try {
			return (EmpwocoInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmpwocoInfo merge(WeekdayInfo sourceOne, EmpwocoInfo sourceTwo) {
		sourceTwo.txtWeekday = sourceOne.txtWeekday;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(WeekdayInfo sourceOne, EmpwocoInfo sourceTwo) {		
		return (sourceOne.codWeekday == sourceTwo.codWeekday		&&
				sourceOne.codLanguage.equals(sourceTwo.codLanguage)		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
