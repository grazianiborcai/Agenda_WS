package br.com.gda.business.feeOwner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.feeDefault.info.FeedefInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class FeewnerVisiMergeFeedef implements InfoMergerVisitorV2<FeewnerInfo, FeedefInfo> {

	@Override public FeewnerInfo writeRecord(FeedefInfo sourceOne, FeewnerInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		FeewnerInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(FeedefInfo sourceOne, FeewnerInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private FeewnerInfo makeClone(FeewnerInfo recordInfo) {
		try {
			return (FeewnerInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private FeewnerInfo merge(FeedefInfo sourceOne, FeewnerInfo sourceTwo) {
		sourceTwo.price = sourceOne.price;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(FeedefInfo sourceOne, FeewnerInfo sourceTwo) {
		return (sourceOne.codCurr.equals(sourceTwo.codCurr));
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
