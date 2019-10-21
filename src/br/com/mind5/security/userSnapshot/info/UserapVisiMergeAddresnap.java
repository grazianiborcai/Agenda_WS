package br.com.mind5.security.userSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class UserapVisiMergeAddresnap implements InfoMergerVisitor<UserapInfo, AddresnapInfo> {

	@Override public UserapInfo writeRecord(AddresnapInfo sourceOne, UserapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UserapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(AddresnapInfo sourceOne, UserapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UserapInfo makeClone(UserapInfo recordInfo) {
		try {
			return (UserapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private UserapInfo merge(AddresnapInfo sourceOne, UserapInfo sourceTwo) {
		sourceTwo.addresses.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(AddresnapInfo sourceOne, UserapInfo sourceTwo) {
		return (sourceOne.codOwner 			== sourceTwo.codOwner 		&& 
				sourceOne.codUser			== sourceTwo.codUser  		&&
				sourceOne.codUserSnapshot	== sourceTwo.codSnapshot		);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
