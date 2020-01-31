package br.com.mind5.business.materialStore.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatoreVisiMergeMatorap implements InfoMergerVisitor_<MatoreInfo, MatorapInfo> {

	@Override public MatoreInfo writeRecord(MatorapInfo sourceOne, MatoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(MatorapInfo sourceOne, MatoreInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatoreInfo merge(MatorapInfo sourceOne, MatoreInfo sourceTwo) {
		MatoreInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codSnapshot = sourceOne.codSnapshot;
		
		return resultInfo;
	}
	
	
	
	private MatoreInfo makeClone(MatoreInfo recordInfo) {
		try {
			return (MatoreInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(MatorapInfo sourceOne, MatoreInfo sourceTwo) {
		return (sourceOne.codOwner 	== sourceTwo.codOwner	&&
				sourceOne.codMat 	== sourceTwo.codMat		&&
				sourceOne.codStore 	== sourceTwo.codStore		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
