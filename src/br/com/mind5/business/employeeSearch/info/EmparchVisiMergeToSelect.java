package br.com.mind5.business.employeeSearch.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class EmparchVisiMergeToSelect implements InfoMergerVisitor<EmparchInfo, EmparchInfo> {

	@Override public EmparchInfo writeRecord(EmparchInfo sourceOne, EmparchInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(EmparchInfo sourceOne, EmparchInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmparchInfo merge(EmparchInfo sourceOne, EmparchInfo sourceTwo) {
		EmparchInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private EmparchInfo makeClone(EmparchInfo recordInfo) {
		try {
			return (EmparchInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(EmparchInfo sourceOne, EmparchInfo sourceTwo) {		
		return (sourceOne.codOwner    == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
