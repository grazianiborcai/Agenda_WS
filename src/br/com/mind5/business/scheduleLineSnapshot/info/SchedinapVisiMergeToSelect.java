package br.com.mind5.business.scheduleLineSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedinapVisiMergeToSelect implements InfoMergerVisitor_<SchedinapInfo, SchedinapInfo> {

	@Override public SchedinapInfo writeRecord(SchedinapInfo sourceOne, SchedinapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(SchedinapInfo sourceOne, SchedinapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private SchedinapInfo merge(SchedinapInfo sourceOne, SchedinapInfo sourceTwo) {
		SchedinapInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private SchedinapInfo makeClone(SchedinapInfo recordInfo) {
		try {
			return (SchedinapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(SchedinapInfo sourceOne, SchedinapInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
