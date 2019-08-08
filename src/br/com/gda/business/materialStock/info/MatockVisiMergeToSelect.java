package br.com.gda.business.materialStock.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatockVisiMergeToSelect implements InfoMergerVisitor<MatockInfo, MatockInfo> {

	@Override public MatockInfo writeRecord(MatockInfo sourceOne, MatockInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(MatockInfo sourceOne, MatockInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatockInfo merge(MatockInfo sourceOne, MatockInfo sourceTwo) {
		MatockInfo result = makeClone(sourceOne);
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private MatockInfo makeClone(MatockInfo recordInfo) {
		try {
			return (MatockInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(MatockInfo sourceOne, MatockInfo sourceTwo) {		
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
