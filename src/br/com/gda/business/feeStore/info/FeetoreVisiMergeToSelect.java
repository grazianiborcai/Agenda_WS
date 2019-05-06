package br.com.gda.business.feeStore.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class FeetoreVisiMergeToSelect implements InfoMergerVisitorV2<FeetoreInfo, FeetoreInfo> {

	@Override public FeetoreInfo writeRecord(FeetoreInfo sourceOne, FeetoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		FeetoreInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codLanguage = sourceOne.codLanguage;
		resultInfo.username = sourceOne.username;

		return resultInfo;
	}
	
	
	
	private void checkArgument(FeetoreInfo sourceOne, FeetoreInfo sourceTwo) {
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



	@Override public boolean shouldWrite(FeetoreInfo sourceOne, FeetoreInfo sourceTwo) {
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
