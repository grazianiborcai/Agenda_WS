package br.com.gda.business.schedule.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OrderemVisiMergeEmplis implements InfoMergerVisitor<ScheduInfo, EmplisInfo> {

	@Override public ScheduInfo writeRecord(EmplisInfo sourceOne, ScheduInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		ScheduInfo resultInfo = makeClone(sourceTwo);
		resultInfo.emplisData = sourceOne;
		return resultInfo;
	}
	
	
	
	private void checkArgument(EmplisInfo sourceOne, ScheduInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private ScheduInfo makeClone(ScheduInfo recordInfo) {
		try {
			return (ScheduInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(EmplisInfo sourceOne, ScheduInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner 	&& 
				sourceOne.codEmployee 	== sourceTwo.codEmployee	);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
