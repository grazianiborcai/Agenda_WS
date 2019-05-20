package br.com.gda.business.userSnapshot_.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.obsolete.InfoMergerVisitor_;

final class UserSnapVisitorAddressSnap implements InfoMergerVisitor_<UserSnapInfo, AddresnapInfo, UserSnapInfo> {

	@Override public UserSnapInfo writeRecord(AddresnapInfo sourceOne, UserSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UserSnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(AddresnapInfo sourceOne, UserSnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UserSnapInfo makeClone(UserSnapInfo recordInfo) {
		try {
			return (UserSnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private UserSnapInfo merge(AddresnapInfo sourceOne, UserSnapInfo sourceTwo) {
		sourceTwo.addresses.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(AddresnapInfo sourceOne, UserSnapInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner 		&& 
				sourceOne.codUser		== sourceTwo.codUser  		&&
				sourceOne.codSnapshot	== sourceTwo.codSnapshot		);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
