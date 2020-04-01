package br.com.mind5.business.phone.info;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhoneVisiMergePhonarch implements InfoMergerVisitor_<PhoneInfo, PhonarchInfo> {

	@Override public PhoneInfo writeRecord(PhonarchInfo sourceOne, PhoneInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PhoneInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PhonarchInfo sourceOne, PhoneInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PhoneInfo makeClone(PhoneInfo recordInfo) {
		try {
			return (PhoneInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PhoneInfo merge(PhonarchInfo sourceOne, PhoneInfo sourceTwo) {
		return PhoneInfo.copyFrom(sourceOne);
	}
	
	
	
	@Override public boolean shouldWrite(PhonarchInfo sourceOne, PhoneInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}	
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
