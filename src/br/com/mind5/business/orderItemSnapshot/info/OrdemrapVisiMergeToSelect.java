package br.com.mind5.business.orderItemSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class OrdemrapVisiMergeToSelect implements InfoMergerVisitor<OrdemrapInfo, OrdemrapInfo> {

	@Override public OrdemrapInfo writeRecord(OrdemrapInfo sourceOne, OrdemrapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(OrdemrapInfo sourceOne, OrdemrapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrdemrapInfo merge(OrdemrapInfo sourceOne, OrdemrapInfo sourceTwo) {
		OrdemrapInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private OrdemrapInfo makeClone(OrdemrapInfo recordInfo) {
		try {
			return (OrdemrapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(OrdemrapInfo sourceOne, OrdemrapInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
