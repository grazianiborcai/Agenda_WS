package br.com.gda.business.feeStore.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class FeeStoreVisitorDefault implements InfoMergerVisitor<FeeStoreInfo, FeeDefaultInfo, FeeStoreInfo> {

	@Override public FeeStoreInfo writeRecord(FeeDefaultInfo sourceOne, FeeStoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		FeeStoreInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codCurr = sourceOne.codCurr;
		resultInfo.price = sourceOne.price;

		return resultInfo;
	}
	
	
	
	private void checkArgument(FeeDefaultInfo sourceOne, FeeStoreInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private FeeStoreInfo makeClone(FeeStoreInfo recordInfo) {
		try {
			return (FeeStoreInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	

	
	@Override public boolean shouldWrite(FeeDefaultInfo sourceOne, FeeStoreInfo sourceTwo) {
		return (sourceOne.codFeeCateg == sourceTwo.codFeeCateg);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
