package br.com.gda.business.employeeSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class EmpnapVisiMergePhonap implements InfoMergerVisitor<EmpnapInfo, PhonapInfo> {

	@Override public EmpnapInfo writeRecord(PhonapInfo sourceOne, EmpnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PhonapInfo sourceOne, EmpnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpnapInfo makeClone(EmpnapInfo recordInfo) {
		try {
			return (EmpnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmpnapInfo merge(PhonapInfo sourceOne, EmpnapInfo sourceTwo) {
		sourceTwo.phonaps.add(sourceOne);

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(PhonapInfo sourceOne, EmpnapInfo sourceTwo) {
		return (sourceOne.codOwner 				== sourceTwo.codOwner 		&&
				sourceOne.codEmployee 			== sourceTwo.codEmployee	&&
				sourceOne.codEmployeeSnapshot 	== sourceTwo.codSnapshot		);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
