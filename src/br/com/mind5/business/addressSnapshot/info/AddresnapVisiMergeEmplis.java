package br.com.mind5.business.addressSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class AddresnapVisiMergeEmplis implements InfoMergerVisitor<AddresnapInfo, EmplisInfo> {

	@Override public AddresnapInfo writeRecord(EmplisInfo sourceOne, AddresnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		AddresnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(EmplisInfo sourceOne, AddresnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private AddresnapInfo makeClone(AddresnapInfo recordInfo) {
		try {
			return (AddresnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private AddresnapInfo merge(EmplisInfo sourceOne, AddresnapInfo sourceTwo) {
		sourceTwo.codEmployeeSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(EmplisInfo sourceOne, AddresnapInfo sourceTwo) {
		return (sourceOne.codOwner  	== sourceTwo.codOwner	&&
				sourceOne.codEmployee 	== sourceTwo.codEmployee);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
