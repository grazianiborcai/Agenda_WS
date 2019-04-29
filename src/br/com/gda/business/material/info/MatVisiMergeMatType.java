package br.com.gda.business.material.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor_;

final class MatVisiMergeMatType implements InfoMergerVisitor_<MatInfo, MatTypeInfo, MatInfo> {

	@Override public MatInfo writeRecord(MatTypeInfo sourceOne, MatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatTypeInfo sourceOne, MatInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatInfo makeClone(MatInfo recordInfo) {
		try {
			return (MatInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private MatInfo merge(MatTypeInfo sourceOne, MatInfo sourceTwo) {
		sourceTwo.codType = sourceOne.codType;
		sourceTwo.txtType = sourceOne.txtType;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(MatTypeInfo sourceOne, MatInfo sourceTwo) {
		return (sourceOne.codType == sourceTwo.codType);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
