package br.com.mind5.business.employeeWorkTimeOutlier.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpwoutVisiMergeToSelect implements InfoMergerVisitor_<EmpwoutInfo, EmpwoutInfo> {

	@Override public EmpwoutInfo writeRecord(EmpwoutInfo sourceOne, EmpwoutInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(EmpwoutInfo sourceOne, EmpwoutInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpwoutInfo merge(EmpwoutInfo sourceOne, EmpwoutInfo sourceTwo) {
		EmpwoutInfo result = makeClone(sourceOne);
		
		result.codLanguage = sourceTwo.codLanguage;
		result.username = sourceTwo.username;
		
		return result;
	}
	
	
	
	private EmpwoutInfo makeClone(EmpwoutInfo recordInfo) {
		try {
			return (EmpwoutInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(EmpwoutInfo sourceOne, EmpwoutInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
