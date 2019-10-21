package br.com.mind5.business.planningTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class PlanimeVisiMergeStolis implements InfoMergerVisitor<PlanimeInfo, StolisInfo> {

	@Override public PlanimeInfo writeRecord(StolisInfo sourceOne, PlanimeInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
				
		StolisInfo clonedStore = makeClone(sourceOne);
		sourceTwo.stores.add(clonedStore);
		
		return sourceTwo;
	}
	
	
	
	private void checkArgument(StolisInfo sourceOne, PlanimeInfo sourceTwo) {		
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StolisInfo makeClone(StolisInfo store) {
		try {
			return (StolisInfo) store.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}



	@Override public boolean shouldWrite(StolisInfo sourceOne, PlanimeInfo sourceTwo) {		
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
