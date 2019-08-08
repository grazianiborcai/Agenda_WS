package br.com.gda.business.employee.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class EmpVisiMergeEmpnap implements InfoMergerVisitor<EmpInfo, EmpnapInfo> {

	@Override public EmpInfo writeRecord(EmpnapInfo sourceOne, EmpInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(EmpnapInfo sourceOne, EmpInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpInfo makeClone(EmpInfo recordInfo) {
		try {
			return (EmpInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmpInfo merge(EmpnapInfo sourceOne, EmpInfo sourceTwo) {
		sourceTwo.codSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(EmpnapInfo sourceOne, EmpInfo sourceTwo) {		
		return (sourceOne.codOwner 	  == sourceTwo.codOwner		&&
				sourceOne.codEmployee == sourceTwo.codEmployee		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
