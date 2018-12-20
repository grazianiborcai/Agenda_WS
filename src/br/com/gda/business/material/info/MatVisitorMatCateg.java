package br.com.gda.business.material.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatVisitorMatCateg implements InfoMergerVisitor<MatInfo, MatCategInfo, MatInfo> {

	@Override public MatInfo writeRecord(MatCategInfo sourceOne, MatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatCategInfo sourceOne, MatInfo sourceTwo) {
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
	
	
	
	private MatInfo merge(MatCategInfo sourceOne, MatInfo sourceTwo) {
		sourceTwo.codCategory = sourceOne.codCategory;
		sourceTwo.txtCategory = sourceOne.txtCategory;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(MatCategInfo sourceOne, MatInfo sourceTwo) {
		return (sourceOne.codCategory == sourceTwo.codCategory);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
