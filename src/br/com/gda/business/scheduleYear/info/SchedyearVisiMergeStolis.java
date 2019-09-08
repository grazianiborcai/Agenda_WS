package br.com.gda.business.scheduleYear.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class SchedyearVisiMergeStolis implements InfoMergerVisitor<SchedyearInfo, StolisInfo> {

	@Override public SchedyearInfo writeRecord(StolisInfo sourceOne, SchedyearInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		SchedyearInfo resultInfo = makeClone(sourceTwo);
		resultInfo.stolisData = sourceOne;

		return resultInfo;
	}
	
	
	
	private void checkArgument(StolisInfo sourceOne, SchedyearInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	
	
	
	
	private SchedyearInfo makeClone(SchedyearInfo recordInfo) {
		try {
			return (SchedyearInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(StolisInfo sourceOne, SchedyearInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
