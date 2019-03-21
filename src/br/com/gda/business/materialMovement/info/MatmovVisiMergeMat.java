package br.com.gda.business.materialMovement.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatmovVisiMergeMat implements InfoMergerVisitor<MatmovInfo, MatInfo, MatmovInfo> {

	@Override public MatmovInfo writeRecord(MatInfo sourceOne, MatmovInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatmovInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatInfo sourceOne, MatmovInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatmovInfo makeClone(MatmovInfo recordInfo) {
		try {
			return (MatmovInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private MatmovInfo merge(MatInfo sourceOne, MatmovInfo sourceTwo) {
		sourceTwo.codMatCateg = sourceOne.codMatCateg;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(MatInfo sourceOne, MatmovInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner	&&
				sourceOne.codMat   == sourceTwo.codMat			);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
