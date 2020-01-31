package br.com.mind5.security.userAuthentication.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.userList.info.UselisInfo;

final class UauthVisiMergeUselis implements InfoMergerVisitor_<UauthInfo, UselisInfo> {

	@Override public UauthInfo writeRecord(UselisInfo sourceOne, UauthInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UauthInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UselisInfo sourceOne, UauthInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UauthInfo makeClone(UauthInfo recordInfo) {
		try {
			return (UauthInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private UauthInfo merge(UselisInfo sourceOne, UauthInfo sourceTwo) {
		return UauthInfo.copyFrom(sourceOne);
	}
	
	
	
	@Override public boolean shouldWrite(UselisInfo sourceOne, UauthInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner 	&&
				sourceOne.username.equals(sourceTwo.username));
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
