package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StolateVisiMergeStolis implements InfoMergerVisitor_<StolateInfo, StolisInfo> {

	@Override public StolateInfo writeRecord(StolisInfo sourceOne, StolateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StolateInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(StolisInfo sourceOne, StolateInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StolateInfo makeClone(StolateInfo recordInfo) {
		try {
			return (StolateInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private StolateInfo merge(StolisInfo sourceOne, StolateInfo sourceTwo) {
		sourceTwo.codTimezone = sourceOne.codTimezone;
		sourceTwo.txtTimezone = sourceOne.txtTimezone;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(StolisInfo sourceOne, StolateInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner	&&
				sourceOne.codStore == sourceTwo.codStore		);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
