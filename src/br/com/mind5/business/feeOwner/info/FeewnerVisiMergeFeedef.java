package br.com.mind5.business.feeOwner.info;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class FeewnerVisiMergeFeedef implements InfoMergerVisitor_<FeewnerInfo, FeedefInfo> {

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
		SystemLog.logError(this.getClass(), e);
	}
}
