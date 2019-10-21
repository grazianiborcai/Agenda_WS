package br.com.mind5.business.storeList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class StolisVisiMergeAddress implements InfoMergerVisitor<StolisInfo, AddressInfo> {

	@Override public StolisInfo writeRecord(AddressInfo sourceOne, StolisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StolisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(AddressInfo sourceOne, StolisInfo sourceTwo) {
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
	
	
	
	private StolisInfo merge(AddressInfo sourceOne, StolisInfo sourceTwo) {
		sourceTwo.addresses.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(AddressInfo sourceOne, StolisInfo sourceTwo) {
		return (sourceOne.codOwner 	== sourceTwo.codOwner &&
				sourceOne.codStore 	== sourceTwo.codStore		);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
