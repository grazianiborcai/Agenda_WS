package br.com.gda.business.storeLeaveDate.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor_;

final class StolevateVisiMergeToDelete implements InfoMergerVisitor_<StolevateInfo, StolevateInfo, StolevateInfo> {

	@Override public StolevateInfo writeRecord(StolevateInfo sourceOne, StolevateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(StolevateInfo sourceOne, StolevateInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StolevateInfo merge(StolevateInfo sourceOne, StolevateInfo sourceTwo) {
		StolevateInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private StolevateInfo makeClone(StolevateInfo recordInfo) {
		try {
			return (StolevateInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(StolevateInfo sourceOne, StolevateInfo sourceTwo) {		
		return (sourceOne.codOwner 	 == sourceTwo.codOwner	&& 
				sourceOne.codStore 	 == sourceTwo.codStore	);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
