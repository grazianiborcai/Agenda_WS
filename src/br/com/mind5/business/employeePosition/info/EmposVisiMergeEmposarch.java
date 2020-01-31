package br.com.mind5.business.employeePosition.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmposVisiMergeEmposarch implements InfoMergerVisitor_<EmposInfo, EmposarchInfo> {

	@Override public EmposInfo writeRecord(EmposarchInfo sourceOne, EmposInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmposInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(EmposarchInfo sourceOne, EmposInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmposInfo makeClone(EmposInfo recordInfo) {
		try {
			return (EmposInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmposInfo merge(EmposarchInfo sourceOne, EmposInfo sourceTwo) {
		EmposInfo result = new EmposInfo();
		
		result.codOwner = sourceOne.codOwner;
		result.codStore = sourceOne.codStore;	
		result.codEmployee = sourceOne.codEmployee;
		result.codPosition = sourceOne.codPosition;
		result.username = sourceOne.username;
		result.codLanguage = sourceOne.codLanguage;

		return result;
	}
	
	
	
	@Override public boolean shouldWrite(EmposarchInfo sourceOne, EmposInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
