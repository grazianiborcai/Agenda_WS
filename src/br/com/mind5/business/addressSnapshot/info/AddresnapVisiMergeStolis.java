package br.com.mind5.business.addressSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class AddresnapVisiMergeStolis implements InfoMergerVisitor<AddresnapInfo, StolisInfo> {

	@Override public AddresnapInfo writeRecord(StolisInfo sourceOne, AddresnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		AddresnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(StolisInfo sourceOne, AddresnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private AddresnapInfo makeClone(AddresnapInfo recordInfo) {
		try {
			return (AddresnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private AddresnapInfo merge(StolisInfo sourceOne, AddresnapInfo sourceTwo) {
		sourceTwo.codStoreSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(StolisInfo sourceOne, AddresnapInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner	&&
				sourceOne.codStore 	== sourceTwo.codStore);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
