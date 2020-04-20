package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;

final class StorapVisiMergeTimezone implements InfoMergerVisitor_<StorapInfo, TimezoneInfo> {

	@Override public StorapInfo writeRecord(TimezoneInfo sourceOne, StorapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StorapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(TimezoneInfo sourceOne, StorapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StorapInfo makeClone(StorapInfo recordInfo) {
		try {
			return (StorapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private StorapInfo merge(TimezoneInfo sourceOne, StorapInfo sourceTwo) {
		sourceTwo.txtTimezone = sourceOne.txtTimezone;

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(TimezoneInfo sourceOne, StorapInfo sourceTwo) {
		return (sourceOne.codTimezone.equals(sourceTwo.codTimezone));
	}	
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
