package br.com.gda.business.feeStore.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoWriteVisitor;

final class FeeStoreVisitorStore implements InfoWriteVisitor<FeeStoreInfo, StoreInfo, FeeStoreInfo> {

	@Override public FeeStoreInfo writeRecord(StoreInfo sourceOne, FeeStoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		FeeStoreInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codCurr = sourceOne.codCurr;

		return resultInfo;
	}
	
	
	
	private void checkArgument(StoreInfo sourceOne, FeeStoreInfo sourceTwo) {
		if (sourceOne.codOwner != sourceTwo.codOwner)
			throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		
		if (sourceOne.codStore != sourceTwo.codStore)
			throw new IllegalArgumentException("codStore" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
	
	
	
	private FeeStoreInfo makeClone(FeeStoreInfo recordInfo) {
		try {
			return (FeeStoreInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}
}
