package br.com.mind5.business.address.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.security.username.info.UsernameInfo;

final class AddressVisiMergeUsername implements InfoMergerVisitor<AddressInfo, UsernameInfo> {

	@Override public AddressInfo writeRecord(UsernameInfo sourceOne, AddressInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		AddressInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UsernameInfo sourceOne, AddressInfo sourceTwo) {
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
	
	
	
	private AddressInfo merge(UsernameInfo sourceOne, AddressInfo sourceTwo) {
		sourceTwo.lastChangedBy = sourceOne.codUser;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(UsernameInfo sourceOne, AddressInfo sourceTwo) {
		if (sourceOne.username == null ||
			sourceTwo.username == null		)
			return false;
		
		return (sourceOne.codOwner == sourceTwo.codOwner		&&
				sourceOne.username.equals(sourceTwo.username)		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
