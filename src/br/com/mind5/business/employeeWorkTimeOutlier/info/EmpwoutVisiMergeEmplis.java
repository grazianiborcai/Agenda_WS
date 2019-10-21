package br.com.mind5.business.employeeWorkTimeOutlier.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class EmpwoutVisiMergeEmplis implements InfoMergerVisitor<EmpwoutInfo, EmplisInfo> {

	@Override public EmpwoutInfo writeRecord(EmplisInfo sourceOne, EmpwoutInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpwoutInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(EmplisInfo sourceOne, EmpwoutInfo sourceTwo) {
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
	
	
	
	private EmpwoutInfo merge(EmplisInfo sourceOne, EmpwoutInfo sourceTwo) {
		sourceTwo.empData = sourceOne;		
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(EmplisInfo sourceOne, EmpwoutInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner	&&
				sourceOne.codEmployee 	== sourceTwo.codEmployee);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
