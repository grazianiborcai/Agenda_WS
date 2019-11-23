package br.com.mind5.business.employeeWorkTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class EmpwotmVisiMergeStowotm implements InfoMergerVisitor<EmpwotmInfo, StowotmInfo> {

	@Override public EmpwotmInfo writeRecord(StowotmInfo sourceOne, EmpwotmInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpwotmInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(StowotmInfo sourceOne, EmpwotmInfo sourceTwo) {
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
	
	
	
	private EmpwotmInfo merge(StowotmInfo sourceOne, EmpwotmInfo sourceTwo) {
		sourceTwo.beginTime = sourceOne.beginTime;
		sourceTwo.endTime = sourceOne.endTime;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(StowotmInfo sourceOne, EmpwotmInfo sourceTwo) {		
		return (sourceOne.codOwner   == sourceTwo.codOwner		&&
				sourceOne.codStore   == sourceTwo.codStore		&&
				sourceOne.codWeekday == sourceTwo.codWeekday);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
