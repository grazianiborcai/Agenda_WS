package br.com.gda.business.ownerStore.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OwntoreVisiMergeToSelect implements InfoMergerVisitor<OwntoreInfo, OwntoreInfo> {

	@Override public OwntoreInfo writeRecord(OwntoreInfo sourceOne, OwntoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(OwntoreInfo sourceOne, OwntoreInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OwntoreInfo merge(OwntoreInfo sourceOne, OwntoreInfo sourceTwo) {
		OwntoreInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private OwntoreInfo makeClone(OwntoreInfo recordInfo) {
		try {
			return (OwntoreInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(OwntoreInfo sourceOne, OwntoreInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
