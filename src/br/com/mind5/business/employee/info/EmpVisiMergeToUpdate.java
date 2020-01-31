package br.com.mind5.business.employee.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpVisiMergeToUpdate implements InfoMergerVisitor_<EmpInfo, EmpInfo> {

	@Override public EmpInfo writeRecord(EmpInfo sourceOne, EmpInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(EmpInfo sourceOne, EmpInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpInfo merge(EmpInfo sourceOne, EmpInfo sourceTwo) {
		EmpInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		
		if (sourceTwo.addresses != null)
			result.addresses = sourceTwo.addresses;
		
		if (sourceTwo.phones != null)
			result.phones = sourceTwo.phones;
		
		if (sourceTwo.personData != null)
			result.personData = sourceTwo.personData;
		
		return result;
	}
	
	
	
	private EmpInfo makeClone(EmpInfo recordInfo) {
		try {
			return (EmpInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(EmpInfo sourceOne, EmpInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
