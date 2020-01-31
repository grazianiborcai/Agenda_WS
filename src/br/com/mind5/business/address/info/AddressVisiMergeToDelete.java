package br.com.mind5.business.address.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AddressVisiMergeToDelete implements InfoMergerVisitor_<AddressInfo, AddressInfo> {

	@Override public AddressInfo writeRecord(AddressInfo sourceOne, AddressInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(AddressInfo sourceOne, AddressInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private AddressInfo merge(AddressInfo sourceOne, AddressInfo sourceTwo) {
		AddressInfo result = makeClone(sourceOne);		

		result.codLanguage = sourceTwo.codLanguage;
		result.username = sourceTwo.username;
		
		return result;
	}
	
	
	
	private AddressInfo makeClone(AddressInfo recordInfo) {
		try {
			return (AddressInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(AddressInfo sourceOne, AddressInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
