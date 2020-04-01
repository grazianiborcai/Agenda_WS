package br.com.mind5.security.storeAuthorization.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class StorauthVisiMergeUsername implements InfoMergerVisitor_<StorauthInfo, UsernameInfo> {

	@Override public StorauthInfo writeRecord(UsernameInfo sourceOne, StorauthInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StorauthInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UsernameInfo sourceOne, StorauthInfo sourceTwo) {
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
	
	
	
	private StorauthInfo merge(UsernameInfo sourceOne, StorauthInfo sourceTwo) {
		sourceTwo.codUser = sourceOne.codUser;
		sourceTwo.codUserCategory = sourceOne.codUserCategory;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(UsernameInfo sourceOne, StorauthInfo sourceTwo) {
		if (sourceOne.username == null ||
			sourceTwo.username == null		)
			return false;
		
		return (sourceOne.codOwner == sourceTwo.codOwner		&&
				sourceOne.username.equals(sourceTwo.username)		);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
