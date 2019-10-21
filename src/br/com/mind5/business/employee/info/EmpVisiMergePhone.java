package br.com.mind5.business.employee.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class EmpVisiMergePhone implements InfoMergerVisitor<EmpInfo, PhoneInfo> {

	@Override public EmpInfo writeRecord(PhoneInfo sourceOne, EmpInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PhoneInfo sourceOne, EmpInfo sourceTwo) {
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
	
	
	
	private EmpInfo merge(PhoneInfo sourceOne, EmpInfo sourceTwo) {
		sourceTwo.phones.add(sourceOne);

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(PhoneInfo sourceOne, EmpInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner 		&&
				sourceOne.codEmployee 	== sourceTwo.codEmployee		);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
