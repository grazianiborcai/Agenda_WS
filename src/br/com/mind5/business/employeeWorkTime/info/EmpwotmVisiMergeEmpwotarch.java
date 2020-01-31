package br.com.mind5.business.employeeWorkTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpwotmVisiMergeEmpwotarch implements InfoMergerVisitor_<EmpwotmInfo, EmpwotarchInfo> {

	@Override public EmpwotmInfo writeRecord(EmpwotarchInfo sourceOne, EmpwotmInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpwotmInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(EmpwotarchInfo sourceOne, EmpwotmInfo sourceTwo) {
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
	
	
	
	private EmpwotmInfo merge(EmpwotarchInfo sourceOne, EmpwotmInfo sourceTwo) {
		return EmpwotmInfo.copyFrom(sourceOne);
	}
	
	
	
	@Override public boolean shouldWrite(EmpwotarchInfo sourceOne, EmpwotmInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
