package br.com.mind5.business.orderItemSearch.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class OrdemarchVisiMergeToSelect implements InfoMergerVisitor<OrdemarchInfo, OrdemarchInfo> {

	@Override public OrdemarchInfo writeRecord(OrdemarchInfo sourceOne, OrdemarchInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(OrdemarchInfo sourceOne, OrdemarchInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrdemarchInfo merge(OrdemarchInfo sourceOne, OrdemarchInfo sourceTwo) {
		OrdemarchInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private OrdemarchInfo makeClone(OrdemarchInfo recordInfo) {
		try {
			return (OrdemarchInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(OrdemarchInfo sourceOne, OrdemarchInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
