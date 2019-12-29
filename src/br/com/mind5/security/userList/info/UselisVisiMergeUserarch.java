package br.com.mind5.security.userList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.security.userSearch.info.UserarchInfo;

final class UselisVisiMergeUserarch implements InfoMergerVisitor<UselisInfo, UserarchInfo> {

	@Override public UselisInfo writeRecord(UserarchInfo sourceOne, UselisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UselisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UserarchInfo sourceOne, UselisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UselisInfo makeClone(UselisInfo recordInfo) {
		try {
			return (UselisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private UselisInfo merge(UserarchInfo sourceOne, UselisInfo sourceTwo) {
		return UselisInfo.copyFrom(sourceOne);
	}


	
	@Override public boolean shouldWrite(UserarchInfo sourceOne, UselisInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
