package br.com.mind5.business.phoneSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.userList.info.UselisInfo;

final class PhonapVisiMergeUselis implements InfoMergerVisitor_<PhonapInfo, UselisInfo> {

	@Override public PhonapInfo writeRecord(UselisInfo sourceOne, PhonapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PhonapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UselisInfo sourceOne, PhonapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PhonapInfo makeClone(PhonapInfo recordInfo) {
		try {
			return (PhonapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PhonapInfo merge(UselisInfo sourceOne, PhonapInfo sourceTwo) {
		sourceTwo.codUserSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(UselisInfo sourceOne, PhonapInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner	&&
				sourceOne.codUser 	== sourceTwo.codUser);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
