package br.com.mind5.business.employeeLeaveDate.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class EmplateVisiMergeEmplarch implements InfoMergerVisitor<EmplateInfo, EmplarchInfo> {

	@Override public EmplateInfo writeRecord(EmplarchInfo sourceOne, EmplateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmplateInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(EmplarchInfo sourceOne, EmplateInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmplateInfo makeClone(EmplateInfo recordInfo) {
		try {
			return (EmplateInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmplateInfo merge(EmplarchInfo sourceOne, EmplateInfo sourceTwo) {
		return EmplateInfo.copyFrom(sourceOne);
	}
	
	
	
	@Override public boolean shouldWrite(EmplarchInfo sourceOne, EmplateInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
