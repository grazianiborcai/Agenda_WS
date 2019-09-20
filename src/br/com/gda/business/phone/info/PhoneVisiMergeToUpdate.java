package br.com.gda.business.phone.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PhoneVisiMergeToUpdate implements InfoMergerVisitor<PhoneInfo, PhoneInfo> {

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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
