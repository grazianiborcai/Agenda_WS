package br.com.gda.business.materialSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.obsolete.InfoMergerVisitor_;

final class MatSnapVisitorMatCateg implements InfoMergerVisitor_<MatSnapInfo, MatCategInfo, MatSnapInfo> {

	@Override public MatSnapInfo writeRecord(MatCategInfo sourceOne, MatSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatSnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatCategInfo sourceOne, MatSnapInfo sourceTwo) {
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
	
	
	
	private MatSnapInfo merge(MatCategInfo sourceOne, MatSnapInfo sourceTwo) {
		sourceTwo.codCategory = sourceOne.codMatCateg;
		sourceTwo.txtCategory = sourceOne.txtMatCateg;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(MatCategInfo sourceOne, MatSnapInfo sourceTwo) {
		return (sourceOne.codMatCateg == sourceTwo.codCategory);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
