package br.com.mind5.security.storeAuthorization.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StorauthVisiMergeToSelect implements InfoMergerVisitor_<StorauthInfo, StorauthInfo> {

	@Override public StorauthInfo writeRecord(StorauthInfo sourceOne, StorauthInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(StorauthInfo sourceOne, StorauthInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StorauthInfo merge(StorauthInfo sourceOne, StorauthInfo sourceTwo) {
		StorauthInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private StorauthInfo makeClone(StorauthInfo recordInfo) {
		try {
			return (StorauthInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(StorauthInfo sourceOne, StorauthInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
