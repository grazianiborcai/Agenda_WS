package br.com.gda.business.employeeWorkTimeOutlier.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class EmpwoutVisiMergeStolis implements InfoMergerVisitor<EmpwoutInfo, StolisInfo> {

	@Override public EmpwoutInfo writeRecord(StolisInfo sourceOne, EmpwoutInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpwoutInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(StolisInfo sourceOne, EmpwoutInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpwoutInfo makeClone(EmpwoutInfo recordInfo) {
		try {
			return (EmpwoutInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmpwoutInfo merge(StolisInfo sourceOne, EmpwoutInfo sourceTwo) {
		sourceTwo.codTimezone = sourceOne.codTimezone;
		
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(StolisInfo sourceOne, EmpwoutInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner &&
				sourceOne.codStore == sourceTwo.codStore	);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
