package br.com.mind5.security.user.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class UserVisiMergeAddress implements InfoMergerVisitor<UserInfo, AddressInfo> {

	@Override public UserInfo writeRecord(AddressInfo sourceOne, UserInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UserInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(AddressInfo sourceOne, UserInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UserInfo makeClone(UserInfo recordInfo) {
		try {
			return (UserInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private UserInfo merge(AddressInfo sourceOne, UserInfo sourceTwo) {
		sourceTwo.addresses.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(AddressInfo sourceOne, UserInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner && 
				sourceOne.codUser  == sourceTwo.codUser		);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
