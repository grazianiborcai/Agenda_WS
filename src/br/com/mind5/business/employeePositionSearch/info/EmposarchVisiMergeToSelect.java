package br.com.mind5.business.employeePositionSearch.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class EmposarchVisiMergeToSelect implements InfoMergerVisitor<EmposarchInfo, EmposarchInfo> {

	@Override public EmposarchInfo writeRecord(EmposarchInfo sourceOne, EmposarchInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(EmposarchInfo sourceOne, EmposarchInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmposarchInfo merge(EmposarchInfo sourceOne, EmposarchInfo sourceTwo) {
		EmposarchInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private EmposarchInfo makeClone(EmposarchInfo recordInfo) {
		try {
			return (EmposarchInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(EmposarchInfo sourceOne, EmposarchInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
