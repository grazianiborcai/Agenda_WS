package br.com.mind5.business.customerSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class CusnapVisiMergePerson implements InfoMergerVisitor<CusnapInfo, PersonInfo> {

	@Override public CusnapInfo writeRecord(PersonInfo sourceOne, CusnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CusnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PersonInfo sourceOne, CusnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CusnapInfo makeClone(CusnapInfo recordInfo) {
		try {
			return (CusnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private CusnapInfo merge(PersonInfo sourceOne, CusnapInfo sourceTwo) {
		sourceTwo.codPersonSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(PersonInfo sourceOne, CusnapInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner	&&
				sourceOne.codPerson == sourceTwo.codPerson		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
