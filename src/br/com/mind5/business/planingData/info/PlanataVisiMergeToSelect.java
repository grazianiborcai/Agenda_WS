package br.com.mind5.business.planingData.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class PlanataVisiMergeToSelect implements InfoMergerVisitor<PlanataInfo, PlanataInfo> {

	@Override public PlanataInfo writeRecord(PlanataInfo sourceOne, PlanataInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(PlanataInfo sourceOne, PlanataInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PlanataInfo merge(PlanataInfo sourceOne, PlanataInfo sourceTwo) {
		PlanataInfo result = makeClone(sourceOne);		
		result.date = sourceTwo.date;
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private PlanataInfo makeClone(PlanataInfo recordInfo) {
		try {
			return (PlanataInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(PlanataInfo sourceOne, PlanataInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
