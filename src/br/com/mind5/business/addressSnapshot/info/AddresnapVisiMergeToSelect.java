package br.com.mind5.business.addressSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AddresnapVisiMergeToSelect implements InfoMergerVisitor_<AddresnapInfo, AddresnapInfo> {

	@Override public AddresnapInfo writeRecord(AddresnapInfo sourceOne, AddresnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(AddresnapInfo sourceOne, AddresnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private AddresnapInfo merge(AddresnapInfo sourceOne, AddresnapInfo sourceTwo) {
		AddresnapInfo result = makeClone(sourceOne);		
		result.lastChangedBy = sourceTwo.lastChangedBy;
		result.codLanguage = sourceTwo.codLanguage;
		result.username = sourceTwo.username;
		return result;
	}
	
	
	
	private AddresnapInfo makeClone(AddresnapInfo recordInfo) {
		try {
			return (AddresnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(AddresnapInfo sourceOne, AddresnapInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
