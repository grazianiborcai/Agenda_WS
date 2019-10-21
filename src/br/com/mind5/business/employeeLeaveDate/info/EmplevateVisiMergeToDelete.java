package br.com.mind5.business.employeeLeaveDate.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class EmplevateVisiMergeToDelete implements InfoMergerVisitor<EmplevateInfo, EmplevateInfo> {

	@Override public EmplevateInfo writeRecord(EmplevateInfo sourceOne, EmplevateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(EmplevateInfo sourceOne, EmplevateInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmplevateInfo merge(EmplevateInfo sourceOne, EmplevateInfo sourceTwo) {
		EmplevateInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private EmplevateInfo makeClone(EmplevateInfo recordInfo) {
		try {
			return (EmplevateInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(EmplevateInfo sourceOne, EmplevateInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
