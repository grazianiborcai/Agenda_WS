package br.com.mind5.business.planningTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PlanimeVisiPlanata implements InfoMergerVisitor_<PlanimeInfo, PlanataInfo> {

	@Override public PlanimeInfo writeRecord(PlanataInfo sourceOne, PlanimeInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PlanimeInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PlanataInfo sourceOne, PlanimeInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PlanimeInfo makeClone(PlanimeInfo recordInfo) {
		try {
			return (PlanimeInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PlanimeInfo merge(PlanataInfo sourceOne, PlanimeInfo sourceTwo) {
		PlanataInfo clonedRecord = makeClone(sourceOne);
		sourceTwo.planatas.add(clonedRecord);
		sourceTwo.dates.add(clonedRecord.date);
		return sourceTwo;
	}
	
	
	
	private PlanataInfo makeClone(PlanataInfo recordInfo) {
		try {
			return (PlanataInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	@Override public boolean shouldWrite(PlanataInfo sourceOne, PlanimeInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
