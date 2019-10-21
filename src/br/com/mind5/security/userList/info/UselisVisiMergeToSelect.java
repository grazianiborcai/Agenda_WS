package br.com.mind5.security.userList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class UselisVisiMergeToSelect implements InfoMergerVisitor<UselisInfo, UselisInfo> {

	@Override public UselisInfo writeRecord(UselisInfo sourceOne, UselisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(UselisInfo sourceOne, UselisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UselisInfo merge(UselisInfo sourceOne, UselisInfo sourceTwo) {
		UselisInfo result = makeClone(sourceOne);		
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private UselisInfo makeClone(UselisInfo recordInfo) {
		try {
			return (UselisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(UselisInfo sourceOne, UselisInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
