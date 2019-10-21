package br.com.mind5.business.employee.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoKeeperVisitor_;

final class EmpVisiKeepEmp implements InfoKeeperVisitor_<EmpInfo, EmpInfo> {

	@Override public EmpInfo keepAtribute(EmpInfo sourceOne, EmpInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpInfo clonedInfo = makeClone(sourceTwo);
		return keep(sourceOne, clonedInfo);
	}
	
	
	
	private EmpInfo makeClone(EmpInfo recordInfo) {
		try {
			return (EmpInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	private void checkArgument(EmpInfo sourceOne, EmpInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.KEEP_NOT_ALLOWED);
	}
	
	
	
	private EmpInfo keep(EmpInfo sourceOne, EmpInfo sourceTwo) {
		sourceTwo.codOwner = sourceOne.codOwner;
		sourceTwo.codEmployee = sourceOne.codEmployee;
		sourceTwo.codPerson = sourceOne.codPerson;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(EmpInfo sourceOne, EmpInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
