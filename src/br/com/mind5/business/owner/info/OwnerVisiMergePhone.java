package br.com.mind5.business.owner.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnerVisiMergePhone implements InfoMergerVisitor_<OwnerInfo, PhoneInfo> {

	@Override public OwnerInfo writeRecord(PhoneInfo sourceOne, OwnerInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OwnerInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PhoneInfo sourceOne, OwnerInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OwnerInfo makeClone(OwnerInfo recordInfo) {
		try {
			return (OwnerInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private OwnerInfo merge(PhoneInfo sourceOne, OwnerInfo sourceTwo) {
		sourceTwo.phones.add(sourceOne);

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(PhoneInfo sourceOne, OwnerInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner 	&&
				sourceOne.codOwnerRef 	== sourceTwo.codOwner		);
	}		
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
