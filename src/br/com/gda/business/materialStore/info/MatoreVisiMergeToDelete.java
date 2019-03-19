package br.com.gda.business.materialStore.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatoreVisiMergeToDelete implements InfoMergerVisitor<MatoreInfo, MatoreInfo, MatoreInfo> {

	@Override public MatoreInfo writeRecord(MatoreInfo sourceOne, MatoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(MatoreInfo sourceOne, MatoreInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatoreInfo merge(MatoreInfo sourceOne, MatoreInfo sourceTwo) {
		MatoreInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private MatoreInfo makeClone(MatoreInfo recordInfo) {
		try {
			return (MatoreInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(MatoreInfo sourceOne, MatoreInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner	&& 
				sourceOne.codStore == sourceTwo.codStore		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
