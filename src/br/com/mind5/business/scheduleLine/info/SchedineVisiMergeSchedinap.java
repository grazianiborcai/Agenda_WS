package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedineVisiMergeSchedinap implements InfoMergerVisitor_<SchedineInfo, SchedinapInfo> {

	@Override public SchedineInfo writeRecord(SchedinapInfo sourceOne, SchedineInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		SchedineInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codSnapshot = sourceOne.codSnapshot;

		return resultInfo;
	}
	
	
	
	private void checkArgument(SchedinapInfo sourceOne, SchedineInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(SchedinapInfo sourceOne, SchedineInfo sourceTwo) {
		return (sourceOne.codOwner 	   == sourceTwo.codOwner 	&& 
				sourceOne.codSchedule  == sourceTwo.codSchedule		);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
