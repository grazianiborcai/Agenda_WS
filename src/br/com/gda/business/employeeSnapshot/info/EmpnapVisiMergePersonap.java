package br.com.gda.business.employeeSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class EmpnapVisiMergePersonap implements InfoMergerVisitorV2<EmpnapInfo, PersonapInfo> {

	@Override public EmpnapInfo writeRecord(PersonapInfo sourceOne, EmpnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PersonapInfo sourceOne, EmpnapInfo sourceTwo) {
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
	
	
	
	private EmpnapInfo merge(PersonapInfo sourceOne, EmpnapInfo sourceTwo) {
		sourceTwo.personapData = makeClone(sourceOne);
		return sourceTwo;
	}
	
	
	
	private PersonapInfo makeClone(PersonapInfo recordInfo) {
		try {
			return (PersonapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	@Override public boolean shouldWrite(PersonapInfo sourceOne, EmpnapInfo sourceTwo) {
		return (sourceOne.codOwner    == sourceTwo.codOwner		&&
				sourceOne.codPerson   == sourceTwo.codPerson	&&
				sourceOne.codSnapshot == sourceTwo.codPersonSnapshot);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
