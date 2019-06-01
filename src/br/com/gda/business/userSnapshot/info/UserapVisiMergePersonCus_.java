package br.com.gda.business.userSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class UserapVisiMergePersonCus_ implements InfoMergerVisitorV2<UserapInfo, PersonCusInfo> {

	@Override public UserapInfo writeRecord(PersonCusInfo sourceOne, UserapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UserapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PersonCusInfo sourceOne, UserapInfo sourceTwo) {
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
	
	
	
	private UserapInfo merge(PersonCusInfo sourceOne, UserapInfo sourceTwo) {
		sourceTwo.codCustomer = sourceOne.codCustomer;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(PersonCusInfo sourceOne, UserapInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
