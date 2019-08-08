package br.com.gda.business.feeOwner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class FeewnerVisiMergeToSelect implements InfoMergerVisitor<FeewnerInfo, FeewnerInfo> {

	@Override public FeewnerInfo writeRecord(FeewnerInfo sourceOne, FeewnerInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		FeewnerInfo resultInfo = makeClone(sourceOne);
		resultInfo.codLanguage = sourceTwo.codLanguage;
		resultInfo.username = sourceTwo.username;

		return resultInfo;
	}
	
	
	
	private void checkArgument(FeewnerInfo sourceOne, FeewnerInfo sourceTwo) {
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



	@Override public boolean shouldWrite(FeewnerInfo sourceOne, FeewnerInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
