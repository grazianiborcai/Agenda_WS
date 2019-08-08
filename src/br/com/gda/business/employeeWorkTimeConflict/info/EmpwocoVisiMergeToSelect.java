package br.com.gda.business.employeeWorkTimeConflict.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class EmpwocoVisiMergeToSelect implements InfoMergerVisitor<EmpwocoInfo, EmpwocoInfo> {

	@Override public EmpwocoInfo writeRecord(EmpwocoInfo sourceOne, EmpwocoInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpwocoInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(EmpwocoInfo sourceOne, EmpwocoInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpwocoInfo makeClone(EmpwocoInfo recordInfo) {
		try {
			return (EmpwocoInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmpwocoInfo merge(EmpwocoInfo sourceOne, EmpwocoInfo sourceTwo) {
		sourceTwo.codLanguage = sourceOne.codLanguage;
		sourceTwo.username = sourceOne.username;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(EmpwocoInfo sourceOne, EmpwocoInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
