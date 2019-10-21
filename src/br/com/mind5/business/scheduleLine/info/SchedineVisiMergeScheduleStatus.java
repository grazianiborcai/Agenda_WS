package br.com.mind5.business.scheduleLine.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class SchedineVisiMergeScheduleStatus implements InfoMergerVisitor<SchedineInfo, ScheduleStatusInfo> {

	@Override public SchedineInfo writeRecord(ScheduleStatusInfo sourceOne, SchedineInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		SchedineInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtScheduleStatus = sourceOne.txtScheduleStatus;

		return resultInfo;
	}
	
	
	
	private void checkArgument(ScheduleStatusInfo sourceOne, SchedineInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	
	
	
	
	private SchedineInfo makeClone(SchedineInfo recordInfo) {
		try {
			return (SchedineInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(ScheduleStatusInfo sourceOne, SchedineInfo sourceTwo) {
		if (sourceOne.codScheduleStatus == null ||
			sourceOne.codLanguage		== null ||
			sourceTwo.codScheduleStatus == null ||
			sourceTwo.codLanguage		== null 	)
			
			return false;
				
		
		
		return (sourceOne.codScheduleStatus.equals(sourceTwo.codScheduleStatus) && 
				sourceOne.codLanguage.equals(sourceTwo.codLanguage));
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
