package br.com.mind5.business.scheduleLine.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class SchedineVisiMergeEmplis implements InfoMergerVisitor<SchedineInfo, EmplisInfo> {

	@Override public SchedineInfo writeRecord(EmplisInfo sourceOne, SchedineInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		SchedineInfo resultInfo = makeClone(sourceTwo);
		resultInfo.empData = sourceOne;

		return resultInfo;
	}
	
	
	
	private void checkArgument(EmplisInfo sourceOne, SchedineInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(EmplisInfo sourceOne, SchedineInfo sourceTwo) {
		return (sourceOne.codOwner    == sourceTwo.codOwner 	&& 
				sourceOne.codEmployee == sourceTwo.codEmployee		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
