package br.com.mind5.business.orderItemSnapshot.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdemrapVisiMergeEmplis implements InfoMergerVisitor_<OrdemrapInfo, EmplisInfo> {

	@Override public OrdemrapInfo writeRecord(EmplisInfo sourceOne, OrdemrapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrdemrapInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codEmployeeSnapshot = sourceOne.codSnapshot;
		return resultInfo;
	}
	
	
	
	private void checkArgument(EmplisInfo sourceOne, OrdemrapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrdemrapInfo makeClone(OrdemrapInfo recordInfo) {
		try {
			return (OrdemrapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(EmplisInfo sourceOne, OrdemrapInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner 	&& 
				sourceOne.codEmployee 	== sourceTwo.codEmployee	);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
