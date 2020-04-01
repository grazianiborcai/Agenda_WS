package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedinapVisiMergeEmplis implements InfoMergerVisitor_<SchedinapInfo, EmplisInfo> {

	@Override public SchedinapInfo writeRecord(EmplisInfo sourceOne, SchedinapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		SchedinapInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codEmployeeSnapshot = sourceOne.codSnapshot;

		return resultInfo;
	}
	
	
	
	private void checkArgument(EmplisInfo sourceOne, SchedinapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	
	
	
	
	private SchedinapInfo makeClone(SchedinapInfo recordInfo) {
		try {
			return (SchedinapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(EmplisInfo sourceOne, SchedinapInfo sourceTwo) {
		return (sourceOne.codOwner    == sourceTwo.codOwner && 
				sourceOne.codEmployee == sourceTwo.codEmployee	);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
