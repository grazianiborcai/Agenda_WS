package br.com.gda.business.feeStore.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class FeetoreVisiMergeStore implements InfoMergerVisitorV2<FeetoreInfo, StoreInfo> {

	@Override public FeetoreInfo writeRecord(StoreInfo sourceOne, FeetoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		FeetoreInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codCurr = sourceOne.codCurr;

		return resultInfo;
	}
	
	
	
	private void checkArgument(StoreInfo sourceOne, FeetoreInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private FeetoreInfo makeClone(FeetoreInfo recordInfo) {
		try {
			return (FeetoreInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}



	@Override public boolean shouldWrite(StoreInfo sourceOne, FeetoreInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codStore == sourceTwo.codStore);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
