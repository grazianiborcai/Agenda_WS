package br.com.gda.business.materialSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatSnapVisitorMatType implements InfoMergerVisitor<MatSnapInfo, MatTypeInfo, MatSnapInfo> {

	@Override public MatSnapInfo writeRecord(MatTypeInfo sourceOne, MatSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatSnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatTypeInfo sourceOne, MatSnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatSnapInfo makeClone(MatSnapInfo recordInfo) {
		try {
			return (MatSnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private MatSnapInfo merge(MatTypeInfo sourceOne, MatSnapInfo sourceTwo) {
		sourceTwo.codType = sourceOne.codType;
		sourceTwo.txtType = sourceOne.txtType;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(MatTypeInfo sourceOne, MatSnapInfo sourceTwo) {
		return (sourceOne.codType == sourceTwo.codType);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
