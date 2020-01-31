package br.com.mind5.business.employee.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpVisiMergeEmparch implements InfoMergerVisitor_<EmpInfo, EmparchInfo> {

	@Override public EmpInfo writeRecord(EmparchInfo sourceOne, EmpInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(EmparchInfo sourceOne, EmpInfo sourceTwo) {
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
	
	
	
	private EmpInfo merge(EmparchInfo sourceOne, EmpInfo sourceTwo) {
		return EmpInfo.copyFrom(sourceOne);
	}	
	
	
	
	@Override public boolean shouldWrite(EmparchInfo sourceOne, EmpInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner &&
				sourceOne.codPerson == sourceTwo.codPerson);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
