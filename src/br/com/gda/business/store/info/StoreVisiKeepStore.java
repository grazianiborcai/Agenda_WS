package br.com.gda.business.store.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoKeeperVisitor;

final class StoreVisiKeepStore implements InfoKeeperVisitor<StoreInfo, StoreInfo> {

	@Override public StoreInfo keepAtribute(StoreInfo sourceOne, StoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StoreInfo clonedInfo = makeClone(sourceTwo);
		return keep(sourceOne, clonedInfo);
	}
	
	
	
	private StoreInfo makeClone(StoreInfo recordInfo) {
		try {
			return (StoreInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	private void checkArgument(StoreInfo sourceOne, StoreInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.KEEP_NOT_ALLOWED);
	}
	
	
	
	private StoreInfo keep(StoreInfo sourceOne, StoreInfo sourceTwo) {
		sourceTwo.codOwner = sourceOne.codOwner;
		sourceTwo.codStore = sourceOne.codStore;
		sourceTwo.codPerson = sourceOne.codPerson;
		sourceTwo.codCompany = sourceOne.codCompany;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(StoreInfo sourceOne, StoreInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
