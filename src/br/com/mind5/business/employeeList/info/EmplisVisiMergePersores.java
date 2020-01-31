package br.com.mind5.business.employeeList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.personListRestricted.info.PersoresInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class EmplisVisiMergePersores implements InfoMergerVisitor<EmplisInfo, PersoresInfo> {

	@Override public EmplisInfo writeRecord(PersoresInfo sourceOne, EmplisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmplisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PersoresInfo sourceOne, EmplisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmplisInfo makeClone(EmplisInfo recordInfo) {
		try {
			return (EmplisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmplisInfo merge(PersoresInfo sourceOne, EmplisInfo sourceTwo) {
		sourceTwo.persoresData = sourceOne;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(PersoresInfo sourceOne, EmplisInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
