package br.com.gda.business.employeeWorkTimeConflict.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class EmpwocoVisiMergeTimezone implements InfoMergerVisitor<EmpwocoInfo, TimezoneInfo, EmpwocoInfo> {

	@Override public EmpwocoInfo writeRecord(TimezoneInfo sourceOne, EmpwocoInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpwocoInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(TimezoneInfo sourceOne, EmpwocoInfo sourceTwo) {
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
	
	
	
	private EmpwocoInfo merge(TimezoneInfo sourceOne, EmpwocoInfo sourceTwo) {
		sourceTwo.txtTimezone = sourceOne.txtTimezone;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(TimezoneInfo sourceOne, EmpwocoInfo sourceTwo) {		
		return (sourceOne.codTimezone.equals(sourceTwo.codTimezone)	&&
				sourceOne.codLanguage.equals(sourceTwo.codLanguage)		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
