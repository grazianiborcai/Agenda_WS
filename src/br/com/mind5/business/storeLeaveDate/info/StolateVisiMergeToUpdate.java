package br.com.mind5.business.storeLeaveDate.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class StolateVisiMergeToUpdate implements InfoMergerVisitor<StolateInfo, StolateInfo> {

	@Override public StolateInfo writeRecord(StolateInfo sourceOne, StolateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(StolateInfo sourceOne, StolateInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StolateInfo merge(StolateInfo sourceOne, StolateInfo sourceTwo) {
		StolateInfo result = makeClone(sourceTwo);		
		result.yearValidFrom = sourceOne.yearValidFrom;
		result.monthValidFrom = sourceOne.monthValidFrom;
		result.createdOn = sourceOne.createdOn;
		result.createdBy = sourceOne.createdBy;
		return result;
	}
	
	
	
	private StolateInfo makeClone(StolateInfo recordInfo) {
		try {
			return (StolateInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(StolateInfo sourceOne, StolateInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
