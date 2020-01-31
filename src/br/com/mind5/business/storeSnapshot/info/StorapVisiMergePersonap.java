package br.com.mind5.business.storeSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StorapVisiMergePersonap implements InfoMergerVisitor_<StorapInfo, PersonapInfo> {

	@Override public StorapInfo writeRecord(PersonapInfo sourceOne, StorapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StorapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PersonapInfo sourceOne, StorapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StorapInfo makeClone(StorapInfo recordInfo) {
		try {
			return (StorapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private StorapInfo merge(PersonapInfo sourceOne, StorapInfo sourceTwo) {
		sourceTwo.personData = PersonInfo.copyFrom(sourceTwo);
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(PersonapInfo sourceOne, StorapInfo sourceTwo) {
		return (sourceOne.codOwner    == sourceTwo.codOwner 	&&
				sourceOne.codPerson   == sourceTwo.codPerson	&&
				sourceOne.codSnapshot == sourceTwo.codPersonSnapshot);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
