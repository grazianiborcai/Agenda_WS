package br.com.gda.business.planningTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class PlanimeVisiMergeStore implements InfoMergerVisitorV2<PlanimeInfo, StoreInfo> {

	@Override public PlanimeInfo writeRecord(StoreInfo sourceOne, PlanimeInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
				
		StoreInfo clonedStore = makeClone(sourceOne);
		sourceTwo.stores.add(clonedStore);
		
		return sourceTwo;
	}
	
	
	
	private void checkArgument(StoreInfo sourceOne, PlanimeInfo sourceTwo) {		
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StoreInfo makeClone(StoreInfo store) {
		try {
			return (StoreInfo) store.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}



	@Override public boolean shouldWrite(StoreInfo sourceOne, PlanimeInfo sourceTwo) {		
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
