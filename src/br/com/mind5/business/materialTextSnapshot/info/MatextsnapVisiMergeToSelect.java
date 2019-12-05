package br.com.mind5.business.materialTextSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class MatextsnapVisiMergeToSelect implements InfoMergerVisitor<MatextsnapInfo, MatextsnapInfo> {

	@Override public MatextsnapInfo writeRecord(MatextsnapInfo sourceOne, MatextsnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(MatextsnapInfo sourceOne, MatextsnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatextsnapInfo merge(MatextsnapInfo sourceOne, MatextsnapInfo sourceTwo) {
		MatextsnapInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		return result;
	}
	
	
	
	private MatextsnapInfo makeClone(MatextsnapInfo recordInfo) {
		try {
			return (MatextsnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(MatextsnapInfo sourceOne, MatextsnapInfo sourceTwo) {	
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
