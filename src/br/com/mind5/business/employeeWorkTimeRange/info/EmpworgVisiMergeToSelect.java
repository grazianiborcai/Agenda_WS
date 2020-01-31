package br.com.mind5.business.employeeWorkTimeRange.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpworgVisiMergeToSelect implements InfoMergerVisitor_<EmpworgInfo, EmpworgInfo> {

	@Override public EmpworgInfo writeRecord(EmpworgInfo sourceOne, EmpworgInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(EmpworgInfo sourceOne, EmpworgInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpworgInfo merge(EmpworgInfo sourceOne, EmpworgInfo sourceTwo) {
		EmpworgInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private EmpworgInfo makeClone(EmpworgInfo recordInfo) {
		try {
			return (EmpworgInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(EmpworgInfo sourceOne, EmpworgInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
