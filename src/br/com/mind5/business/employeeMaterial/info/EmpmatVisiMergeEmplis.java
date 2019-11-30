package br.com.mind5.business.employeeMaterial.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class EmpmatVisiMergeEmplis implements InfoMergerVisitor<EmpmatInfo, EmplisInfo> {

	@Override public EmpmatInfo writeRecord(EmplisInfo sourceOne, EmpmatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpmatInfo resultInfo = makeClone(sourceTwo);		
		sourceTwo.emplisData = sourceOne;

		return resultInfo;
	}
	
	
	
	private void checkArgument(EmplisInfo sourceOne, EmpmatInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpmatInfo makeClone(EmpmatInfo recordInfo) {
		try {
			return (EmpmatInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}



	@Override public boolean shouldWrite(EmplisInfo sourceOne, EmpmatInfo sourceTwo) {
		return (sourceOne.codOwner    == sourceTwo.codOwner && 
			    sourceOne.codEmployee == sourceTwo.codEmployee	);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
