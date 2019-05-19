package br.com.gda.business.phoneSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.snapshot_.info.SnapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.obsolete.InfoMergerVisitor_;

final class PhoneSnapVisitorSnap implements InfoMergerVisitor_<PhoneSnapInfo, SnapInfo, PhoneSnapInfo> {

	@Override public PhoneSnapInfo writeRecord(SnapInfo sourceOne, PhoneSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(SnapInfo sourceOne, PhoneSnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PhoneSnapInfo merge(SnapInfo sourceOne, PhoneSnapInfo sourceTwo) {
		PhoneSnapInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codSnapshot = sourceOne.codSnapshot;
		
		return resultInfo;
	}
	
	
	
	private PhoneSnapInfo makeClone(PhoneSnapInfo recordInfo) {
		try {
			return (PhoneSnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(SnapInfo sourceOne, PhoneSnapInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
