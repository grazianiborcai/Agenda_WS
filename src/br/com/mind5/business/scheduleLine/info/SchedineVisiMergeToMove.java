package br.com.mind5.business.scheduleLine.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedineVisiMergeToMove implements InfoMergerVisitor_<SchedineInfo, SchedineInfo> {

	@Override public SchedineInfo writeRecord(SchedineInfo sourceOne, SchedineInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(SchedineInfo sourceOne, SchedineInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private SchedineInfo merge(SchedineInfo sourceOne, SchedineInfo sourceTwo) {
		SchedineInfo result = makeClone(sourceTwo);		
		result.createdOn = sourceOne.createdOn;
		result.createdBy = sourceOne.createdBy;
		result.codOwner = sourceOne.codOwner;
		result.codSchedule = sourceOne.codSchedule;
		result.codOrder = sourceOne.codOrder;
		result.codOrderItem = sourceOne.codOrderItem;
		result.codUser = sourceOne.codUser;
		result.codCustomer = sourceOne.codCustomer;
		result.codMat = sourceOne.codMat;
		result.codScheduleStatusOld = sourceOne.codScheduleStatusOld;
		return result;
	}
	
	
	
	private SchedineInfo makeClone(SchedineInfo recordInfo) {
		try {
			return (SchedineInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(SchedineInfo sourceOne, SchedineInfo sourceTwo) {		
		return (sourceOne.codOwner 	  == sourceTwo.codOwner &&
				sourceOne.codSchedule == sourceTwo.codSchedule);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
