package br.com.mind5.webhook.moipRefund.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.user.info.UserInfo;

final class WokefumoipVisiMergeDaemon implements InfoMergerVisitor_<WokefumoipInfo, UserInfo> {

	@Override public WokefumoipInfo writeRecord(UserInfo sourceOne, WokefumoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		WokefumoipInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UserInfo sourceOne, WokefumoipInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private WokefumoipInfo makeClone(WokefumoipInfo recordInfo) {
		try {
			return (WokefumoipInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private WokefumoipInfo merge(UserInfo sourceOne, WokefumoipInfo sourceTwo) {
		sourceTwo.username = sourceOne.username;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(UserInfo sourceOne, WokefumoipInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
