package br.com.mind5.business.scheduleLine.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class SchedineVisiMergeDuple implements InfoMergerVisitor<SchedineInfo, SchedarchInfo> {

	@Override public SchedineInfo writeRecord(SchedarchInfo sourceOne, SchedineInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		SchedineInfo resultInfo = makeClone(sourceTwo);
		resultInfo.dupleData = sourceOne;

		return resultInfo;
	}
	
	
	
	private void checkArgument(SchedarchInfo sourceOne, SchedineInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(SchedarchInfo sourceOne, SchedineInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
