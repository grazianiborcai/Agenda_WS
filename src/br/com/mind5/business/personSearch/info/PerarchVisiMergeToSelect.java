package br.com.mind5.business.personSearch.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PerarchVisiMergeToSelect implements InfoMergerVisitor_<PerarchInfo, PerarchInfo> {

	@Override public PerarchInfo writeRecord(PerarchInfo sourceOne, PerarchInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(PerarchInfo sourceOne, PerarchInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PerarchInfo merge(PerarchInfo sourceOne, PerarchInfo sourceTwo) {
		PerarchInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private PerarchInfo makeClone(PerarchInfo recordInfo) {
		try {
			return (PerarchInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(PerarchInfo sourceOne, PerarchInfo sourceTwo) {		
		return (sourceOne.codOwner  == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
