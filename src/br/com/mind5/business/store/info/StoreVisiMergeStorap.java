package br.com.mind5.business.store.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoreVisiMergeStorap implements InfoMergerVisitor_<StoreInfo, StorapInfo> {

	@Override public StoreInfo writeRecord(StorapInfo sourceOne, StoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StoreInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(StorapInfo sourceOne, StoreInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StoreInfo makeClone(StoreInfo recordInfo) {
		try {
			return (StoreInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private StoreInfo merge(StorapInfo sourceOne, StoreInfo sourceTwo) {
		sourceTwo.codSnapshot = sourceOne.codSnapshot;

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(StorapInfo sourceOne, StoreInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner	&&
				sourceOne.codStore == sourceTwo.codStore);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
