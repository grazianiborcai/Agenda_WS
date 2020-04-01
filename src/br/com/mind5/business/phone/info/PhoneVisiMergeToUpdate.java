package br.com.mind5.business.phone.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhoneVisiMergeToUpdate implements InfoMergerVisitor_<PhoneInfo, PhoneInfo> {

	@Override public PhoneInfo writeRecord(PhoneInfo sourceOne, PhoneInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(PhoneInfo sourceOne, PhoneInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PhoneInfo merge(PhoneInfo sourceOne, PhoneInfo sourceTwo) {
		PhoneInfo result = makeClone(sourceTwo);	
		
		result.codUser = sourceOne.codUser;
		result.codStore = sourceOne.codStore;
		result.codSnapshot = sourceOne.codSnapshot;
		result.codCustomer = sourceOne.codCustomer;
		result.codEmployee = sourceOne.codEmployee;
		result.codOwnerRef = sourceOne.codOwnerRef;
		result.createdOn = sourceOne.createdOn;
		result.createdBy = sourceOne.createdBy;

		return result;
	}
	
	
	
	private PhoneInfo makeClone(PhoneInfo recordInfo) {
		try {
			return (PhoneInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(PhoneInfo sourceOne, PhoneInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner &&
				sourceOne.codPhone == sourceTwo.codPhone);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
