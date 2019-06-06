package br.com.gda.business.personList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class PersolisVisiMergeToSelect implements InfoMergerVisitorV2<PersolisInfo, PersolisInfo> {

	@Override public PersolisInfo writeRecord(PersolisInfo sourceOne, PersolisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(PersolisInfo sourceOne, PersolisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PersolisInfo merge(PersolisInfo sourceOne, PersolisInfo sourceTwo) {
		PersolisInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private PersolisInfo makeClone(PersolisInfo recordInfo) {
		try {
			return (PersolisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(PersolisInfo sourceOne, PersolisInfo sourceTwo) {		
		return (sourceOne.codOwner  == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
