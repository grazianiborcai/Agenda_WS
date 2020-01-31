package br.com.mind5.business.employeeWorkTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpwotmVisiMergeStowotarch implements InfoMergerVisitor_<EmpwotmInfo, StowotarchInfo> {

	@Override public EmpwotmInfo writeRecord(StowotarchInfo sourceOne, EmpwotmInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpwotmInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(StowotarchInfo sourceOne, EmpwotmInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpwotmInfo makeClone(EmpwotmInfo recordInfo) {
		try {
			return (EmpwotmInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmpwotmInfo merge(StowotarchInfo sourceOne, EmpwotmInfo sourceTwo) {
		sourceTwo.codWeekday = sourceOne.codWeekday;
		sourceTwo.beginTime = sourceOne.beginTime;
		sourceTwo.endTime = sourceOne.endTime;
		
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(StowotarchInfo sourceOne, EmpwotmInfo sourceTwo) {		
		return (sourceOne.codOwner   == sourceTwo.codOwner		&&
				sourceOne.codStore   == sourceTwo.codStore);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
