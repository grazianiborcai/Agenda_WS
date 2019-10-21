package br.com.mind5.business.address.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class AddressVisiMergeAddarch implements InfoMergerVisitor<AddressInfo, AddarchInfo> {

	@Override public AddressInfo writeRecord(AddarchInfo sourceOne, AddressInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		AddressInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(AddarchInfo sourceOne, AddressInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private AddressInfo makeClone(AddressInfo recordInfo) {
		try {
			return (AddressInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private AddressInfo merge(AddarchInfo sourceOne, AddressInfo sourceTwo) {
		return AddressInfo.copyFrom(sourceOne);
	}
	
	
	
	@Override public boolean shouldWrite(AddarchInfo sourceOne, AddressInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
