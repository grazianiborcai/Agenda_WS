package br.com.mind5.business.materialTextSearch.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatextarchVisiMergeToSelect implements InfoMergerVisitor_<MatextarchInfo, MatextarchInfo> {

	@Override public MatextarchInfo writeRecord(MatextarchInfo sourceOne, MatextarchInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(MatextarchInfo sourceOne, MatextarchInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatextarchInfo merge(MatextarchInfo sourceOne, MatextarchInfo sourceTwo) {
		MatextarchInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		return result;
	}
	
	
	
	private MatextarchInfo makeClone(MatextarchInfo recordInfo) {
		try {
			return (MatextarchInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(MatextarchInfo sourceOne, MatextarchInfo sourceTwo) {	
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
