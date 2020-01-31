package br.com.mind5.business.addressSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.userList.info.UselisInfo;

final class AddresnapVisiMergeUselis implements InfoMergerVisitor_<AddresnapInfo, UselisInfo> {

	@Override public AddresnapInfo writeRecord(UselisInfo sourceOne, AddresnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		AddresnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UselisInfo sourceOne, AddresnapInfo sourceTwo) {
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
	
	
	
	private AddresnapInfo merge(UselisInfo sourceOne, AddresnapInfo sourceTwo) {
		sourceTwo.codUserSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(UselisInfo sourceOne, AddresnapInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner	&&
				sourceOne.codUser 	== sourceTwo.codUser);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
