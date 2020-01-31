package br.com.mind5.business.phoneSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhonapVisiMergeStolis implements InfoMergerVisitor_<PhonapInfo, StolisInfo> {

	@Override public PhonapInfo writeRecord(StolisInfo sourceOne, PhonapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PhonapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(StolisInfo sourceOne, PhonapInfo sourceTwo) {
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
	
	
	
	private PhonapInfo merge(StolisInfo sourceOne, PhonapInfo sourceTwo) {
		sourceTwo.codStoreSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(StolisInfo sourceOne, PhonapInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner	&&
				sourceOne.codStore 	== sourceTwo.codStore);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
