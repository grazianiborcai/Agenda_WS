package br.com.mind5.business.orderItemSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdemrapVisiMergeStolis implements InfoMergerVisitor_<OrdemrapInfo, StolisInfo> {

	@Override public OrdemrapInfo writeRecord(StolisInfo sourceOne, OrdemrapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrdemrapInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codStoreSnapshot = sourceOne.codSnapshot;
		return resultInfo;
	}
	
	
	
	private void checkArgument(StolisInfo sourceOne, OrdemrapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrdemrapInfo makeClone(OrdemrapInfo recordInfo) {
		try {
			return (OrdemrapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(StolisInfo sourceOne, OrdemrapInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner && 
				sourceOne.codStore == sourceTwo.codStore	);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
