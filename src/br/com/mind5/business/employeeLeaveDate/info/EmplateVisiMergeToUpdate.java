package br.com.mind5.business.employeeLeaveDate.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmplateVisiMergeToUpdate implements InfoMergerVisitor_<EmplateInfo, EmplateInfo> {

	@Override public EmplateInfo writeRecord(EmplateInfo sourceOne, EmplateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(EmplateInfo sourceOne, EmplateInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmplateInfo merge(EmplateInfo sourceOne, EmplateInfo sourceTwo) {
		EmplateInfo result = makeClone(sourceTwo);		
		result.createdBy = sourceOne.createdBy;
		result.createdOn = sourceOne.createdOn;
		return result;
	}
	
	
	
	private EmplateInfo makeClone(EmplateInfo recordInfo) {
		try {
			return (EmplateInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(EmplateInfo sourceOne, EmplateInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
