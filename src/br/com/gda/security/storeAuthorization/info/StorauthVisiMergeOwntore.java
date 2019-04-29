package br.com.gda.security.storeAuthorization.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor_;

final class StorauthVisiMergeOwntore implements InfoMergerVisitor_<StorauthInfo, OwntoreInfo, StorauthInfo> {

	@Override public StorauthInfo writeRecord(OwntoreInfo sourceOne, StorauthInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StorauthInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(OwntoreInfo sourceOne, StorauthInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StorauthInfo makeClone(StorauthInfo recordInfo) {
		try {
			return (StorauthInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private StorauthInfo merge(OwntoreInfo sourceOne, StorauthInfo sourceTwo) {
		sourceTwo.codStore = sourceOne.codStore;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(OwntoreInfo sourceOne, StorauthInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
