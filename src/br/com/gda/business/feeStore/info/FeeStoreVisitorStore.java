package br.com.gda.business.feeStore.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class FeeStoreVisitorStore implements InfoMergerVisitor<FeeStoreInfo, StoreInfo, FeeStoreInfo> {

	@Override public FeeStoreInfo writeRecord(StoreInfo sourceOne, FeeStoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		FeeStoreInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codCurr = sourceOne.codCurr;

		return resultInfo;
	}
	
	
	
	private void checkArgument(StoreInfo sourceOne, FeeStoreInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private FeeStoreInfo makeClone(FeeStoreInfo recordInfo) {
		try {
			return (FeeStoreInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}



	@Override public boolean shouldWrite(StoreInfo sourceOne, FeeStoreInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codStore == sourceTwo.codStore);
	}
}
