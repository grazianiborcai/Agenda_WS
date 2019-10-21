package br.com.mind5.business.materialText.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class MatextVisiMergeToDelete implements InfoMergerVisitor<MatextInfo, MatextInfo> {

	@Override public MatextInfo writeRecord(MatextInfo sourceOne, MatextInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(MatextInfo sourceOne, MatextInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatextInfo merge(MatextInfo sourceOne, MatextInfo sourceTwo) {
		MatextInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		return result;
	}
	
	
	
	private MatextInfo makeClone(MatextInfo recordInfo) {
		try {
			return (MatextInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(MatextInfo sourceOne, MatextInfo sourceTwo) {	
		return (sourceOne.codOwner == sourceTwo.codOwner	&& 
				sourceOne.codMat   == sourceTwo.codMat			);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
