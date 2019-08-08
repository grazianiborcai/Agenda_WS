package br.com.gda.business.materialStore.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatoreVisiMergeMatock implements InfoMergerVisitor<MatoreInfo, MatockInfo> {

	@Override public MatoreInfo writeRecord(MatockInfo sourceOne, MatoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatoreInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatockInfo sourceOne, MatoreInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatoreInfo makeClone(MatoreInfo recordInfo) {
		try {
			return (MatoreInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private MatoreInfo merge(MatockInfo sourceOne, MatoreInfo sourceTwo) {
		sourceTwo.quantityStock = sourceOne.quantityStock;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(MatockInfo sourceOne, MatoreInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner &&
				sourceOne.codStore == sourceTwo.codStore &&
				sourceOne.codMat   == sourceTwo.codMat		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
