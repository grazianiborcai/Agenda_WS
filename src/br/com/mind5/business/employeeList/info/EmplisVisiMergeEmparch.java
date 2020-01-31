package br.com.mind5.business.employeeList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmplisVisiMergeEmparch implements InfoMergerVisitor_<EmplisInfo, EmparchInfo> {

	@Override public EmplisInfo writeRecord(EmparchInfo sourceOne, EmplisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmplisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(EmparchInfo sourceOne, EmplisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmplisInfo makeClone(EmplisInfo recordInfo) {
		try {
			return (EmplisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmplisInfo merge(EmparchInfo sourceOne, EmplisInfo sourceTwo) {
		return EmplisInfo.copyFrom(sourceOne);
	}	
	
	
	
	@Override public boolean shouldWrite(EmparchInfo sourceOne, EmplisInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner &&
				sourceOne.codPerson == sourceTwo.codPerson);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
