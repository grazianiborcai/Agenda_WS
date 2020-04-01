package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StolateVisiMergeStolarch implements InfoMergerVisitor_<StolateInfo, StolarchInfo> {

	@Override public StolateInfo writeRecord(StolarchInfo sourceOne, StolateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StolateInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(StolarchInfo sourceOne, StolateInfo sourceTwo) {
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
	
	
	
	private StolateInfo merge(StolarchInfo sourceOne, StolateInfo sourceTwo) {
		return StolateInfo.copyFrom(sourceOne);
	}
	
	
	
	@Override public boolean shouldWrite(StolarchInfo sourceOne, StolateInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
