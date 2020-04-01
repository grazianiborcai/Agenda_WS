package br.com.mind5.business.employeeWorkTimeConflict.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpwocoVisiMergeToSelect implements InfoMergerVisitor_<EmpwocoInfo, EmpwocoInfo> {

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
		sourceOne.codLanguage = sourceTwo.codLanguage;
		sourceOne.username = sourceTwo.username;
		return sourceOne;
	}
	
	
	
	@Override public boolean shouldWrite(EmpwocoInfo sourceOne, EmpwocoInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
