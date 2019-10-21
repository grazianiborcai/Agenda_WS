package br.com.mind5.business.ownerSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class OwnerapVisiMergeToSelect implements InfoMergerVisitor<OwnerapInfo, OwnerapInfo> {

	@Override public OwnerapInfo writeRecord(OwnerapInfo sourceOne, OwnerapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(OwnerapInfo sourceOne, OwnerapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OwnerapInfo merge(OwnerapInfo sourceOne, OwnerapInfo sourceTwo) {
		OwnerapInfo result = makeClone(sourceOne);		
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private OwnerapInfo makeClone(OwnerapInfo recordInfo) {
		try {
			return (OwnerapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(OwnerapInfo sourceOne, OwnerapInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
