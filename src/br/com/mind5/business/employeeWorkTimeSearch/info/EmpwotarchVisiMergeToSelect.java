package br.com.mind5.business.employeeWorkTimeSearch.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpwotarchVisiMergeToSelect implements InfoMergerVisitor_<EmpwotarchInfo, EmpwotarchInfo> {

	@Override public EmpwotarchInfo writeRecord(EmpwotarchInfo sourceOne, EmpwotarchInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(EmpwotarchInfo sourceOne, EmpwotarchInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpwotarchInfo merge(EmpwotarchInfo sourceOne, EmpwotarchInfo sourceTwo) {
		EmpwotarchInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private EmpwotarchInfo makeClone(EmpwotarchInfo recordInfo) {
		try {
			return (EmpwotarchInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(EmpwotarchInfo sourceOne, EmpwotarchInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
