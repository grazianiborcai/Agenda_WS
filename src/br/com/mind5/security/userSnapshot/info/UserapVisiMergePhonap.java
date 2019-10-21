package br.com.mind5.security.userSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class UserapVisiMergePhonap implements InfoMergerVisitor<UserapInfo, PhonapInfo> {

	@Override public UserapInfo writeRecord(PhonapInfo sourceOne, UserapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UserapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PhonapInfo sourceOne, UserapInfo sourceTwo) {
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
	
	
	
	private UserapInfo merge(PhonapInfo sourceOne, UserapInfo sourceTwo) {
		sourceTwo.phones.add(sourceOne);

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(PhonapInfo sourceOne, UserapInfo sourceTwo) {
		return (sourceOne.codOwner 			== sourceTwo.codOwner 		&& 
				sourceOne.codUser  			== sourceTwo.codUser  		&&
				sourceOne.codUserSnapshot	== sourceTwo.codSnapshot		);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
