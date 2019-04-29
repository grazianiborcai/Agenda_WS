package br.com.gda.business.employeeLeaveDate.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor_;

final class EmplevateVisiMergeTimezone implements InfoMergerVisitor_<EmplevateInfo, TimezoneInfo, EmplevateInfo> {

	@Override public EmplevateInfo writeRecord(TimezoneInfo sourceOne, EmplevateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmplevateInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(TimezoneInfo sourceOne, EmplevateInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmplevateInfo makeClone(EmplevateInfo recordInfo) {
		try {
			return (EmplevateInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmplevateInfo merge(TimezoneInfo sourceOne, EmplevateInfo sourceTwo) {
		sourceTwo.txtTimezone = sourceOne.txtTimezone;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(TimezoneInfo sourceOne, EmplevateInfo sourceTwo) {		
		return (sourceOne.codTimezone.equals(sourceTwo.codTimezone)	&&
				sourceOne.codLanguage.equals(sourceTwo.codLanguage)		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
