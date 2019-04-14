package br.com.gda.business.employeeMaterial.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class EmpmatVisiMergeEmp implements InfoMergerVisitor<EmpmatInfo, EmpInfo, EmpmatInfo> {

	@Override public EmpmatInfo writeRecord(EmpInfo sourceOne, EmpmatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpmatInfo resultInfo = makeClone(sourceTwo);		
		resultInfo.nameEmployee = sourceOne.personData.name;

		return resultInfo;
	}
	
	
	
	private void checkArgument(EmpInfo sourceOne, EmpmatInfo sourceTwo) {
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



	@Override public boolean shouldWrite(EmpInfo sourceOne, EmpmatInfo sourceTwo) {
		return (sourceOne.codOwner    == sourceTwo.codOwner) && 
			   (sourceOne.codEmployee == sourceTwo.codEmployee	);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
