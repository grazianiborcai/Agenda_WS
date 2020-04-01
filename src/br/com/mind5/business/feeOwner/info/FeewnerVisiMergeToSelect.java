package br.com.mind5.business.feeOwner.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class FeewnerVisiMergeToSelect implements InfoMergerVisitor_<FeewnerInfo, FeewnerInfo> {

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
		SystemLog.logError(this.getClass(), e);
	}
}
