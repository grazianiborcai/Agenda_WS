package br.com.gda.webhook.moipMultipayment.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.security.user.info.UserInfo;

final class WokaymoipVisiMergeDaemon implements InfoMergerVisitor<WokaymoipInfo, UserInfo> {

	@Override public WokaymoipInfo writeRecord(UserInfo sourceOne, WokaymoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		WokaymoipInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UserInfo sourceOne, WokaymoipInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private WokaymoipInfo makeClone(WokaymoipInfo recordInfo) {
		try {
			return (WokaymoipInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private WokaymoipInfo merge(UserInfo sourceOne, WokaymoipInfo sourceTwo) {
		sourceTwo.username = sourceOne.username;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(UserInfo sourceOne, WokaymoipInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
