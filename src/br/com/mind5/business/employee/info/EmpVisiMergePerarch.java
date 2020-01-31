package br.com.mind5.business.employee.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpVisiMergePerarch implements InfoMergerVisitor_<EmpInfo, PerarchInfo> {

	@Override public EmpInfo writeRecord(PerarchInfo sourceOne, EmpInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PerarchInfo sourceOne, EmpInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpInfo makeClone(EmpInfo recordInfo) {
		try {
			return (EmpInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmpInfo merge(PerarchInfo sourceOne, EmpInfo sourceTwo) {
		sourceTwo.codPerson = sourceOne.codPerson;
		return sourceTwo;
	}	
	
	
	
	@Override public boolean shouldWrite(PerarchInfo sourceOne, EmpInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
