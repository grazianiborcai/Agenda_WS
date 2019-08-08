package br.com.gda.business.material.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatVisiMergeMatsnap implements InfoMergerVisitor<MatInfo, MatsnapInfo> {

	@Override public MatInfo writeRecord(MatsnapInfo sourceOne, MatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(MatsnapInfo sourceOne, MatInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatInfo merge(MatsnapInfo sourceOne, MatInfo sourceTwo) {
		MatInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codSnapshot = sourceOne.codSnapshot;
		
		return resultInfo;
	}
	
	
	
	private MatInfo makeClone(MatInfo recordInfo) {
		try {
			return (MatInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(MatsnapInfo sourceOne, MatInfo sourceTwo) {
		return (sourceOne.codOwner 	== sourceTwo.codOwner	&&
				sourceOne.codMat 	== sourceTwo.codMat			);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
