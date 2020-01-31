package br.com.mind5.business.personListRestricted.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PersoresVisiMergePersolis implements InfoMergerVisitor_<PersoresInfo, PersolisInfo> {

	@Override public PersoresInfo writeRecord(PersolisInfo sourceOne, PersoresInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PersoresInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PersolisInfo sourceOne, PersoresInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PersoresInfo makeClone(PersoresInfo recordInfo) {
		try {
			return (PersoresInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PersoresInfo merge(PersolisInfo sourceOne, PersoresInfo sourceTwo) {
		return PersoresInfo.copyFrom(sourceOne);
	}
	
	
	
	@Override public boolean shouldWrite(PersolisInfo sourceOne, PersoresInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner	&&
				sourceOne.codPerson == sourceTwo.codPerson);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
