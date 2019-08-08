package br.com.gda.business.phone.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PhoneVisiMergePhonap implements InfoMergerVisitor<PhoneInfo, PhonapInfo> {

	@Override public PhoneInfo writeRecord(PhonapInfo sourceOne, PhoneInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(PhonapInfo sourceOne, PhoneInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PhoneInfo merge(PhonapInfo sourceOne, PhoneInfo sourceTwo) {
		PhoneInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codSnapshot = sourceOne.codSnapshot;
		
		return resultInfo;
	}
	
	
	
	private PhoneInfo makeClone(PhoneInfo recordInfo) {
		try {
			return (PhoneInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}


	
	@Override public boolean shouldWrite(PhonapInfo sourceOne, PhoneInfo sourceTwo) {
		return (sourceOne.codOwner	== sourceTwo.codOwner	&&
				sourceOne.codPhone	== sourceTwo.codPhone		);
	}
}
