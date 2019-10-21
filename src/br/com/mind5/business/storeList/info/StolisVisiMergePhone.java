package br.com.mind5.business.storeList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class StolisVisiMergePhone implements InfoMergerVisitor<StolisInfo, PhoneInfo> {

	@Override public StolisInfo writeRecord(PhoneInfo sourceOne, StolisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StolisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PhoneInfo sourceOne, StolisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StolisInfo makeClone(StolisInfo recordInfo) {
		try {
			return (StolisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private StolisInfo merge(PhoneInfo sourceOne, StolisInfo sourceTwo) {
		sourceTwo.phones.add(sourceOne);

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(PhoneInfo sourceOne, StolisInfo sourceTwo) {
		return (sourceOne.codOwner 	== sourceTwo.codOwner 	&&
				sourceOne.codStore 	== sourceTwo.codStore		);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
