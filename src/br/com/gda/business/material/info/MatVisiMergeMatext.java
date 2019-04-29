package br.com.gda.business.material.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor_;

final class MatVisiMergeMatext implements InfoMergerVisitor_<MatInfo, MatextInfo, MatInfo> {

	@Override public MatInfo writeRecord(MatextInfo sourceOne, MatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatextInfo sourceOne, MatInfo sourceTwo) {
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
	
	
	
	private MatInfo merge(MatextInfo sourceOne, MatInfo sourceTwo) {
		sourceTwo.txtMat = sourceOne.txtMat;
		sourceTwo.description = sourceOne.description;
		
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(MatextInfo sourceOne, MatInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner	&&
				sourceOne.codMat == sourceTwo.codMat			);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
