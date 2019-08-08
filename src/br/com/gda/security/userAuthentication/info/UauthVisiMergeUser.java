package br.com.gda.security.userAuthentication.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.security.user.info.UserInfo;

final class UauthVisiMergeUser implements InfoMergerVisitorV2<UauthInfo, UserInfo> {

	@Override public UauthInfo writeRecord(UserInfo sourceOne, UauthInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UauthInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UserInfo sourceOne, UauthInfo sourceTwo) {
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
	
	
	
	private UauthInfo merge(UserInfo sourceOne, UauthInfo sourceTwo) {
		return UauthInfo.copyFrom(sourceOne);
	}
	
	
	
	@Override public boolean shouldWrite(UserInfo sourceOne, UauthInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner 	&&
				sourceOne.username.equals(sourceTwo.username));
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
