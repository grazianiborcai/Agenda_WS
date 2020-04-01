package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedinapVisiMergeCuslis implements InfoMergerVisitor_<SchedinapInfo, CuslisInfo> {

	@Override public SchedinapInfo writeRecord(CuslisInfo sourceOne, SchedinapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		SchedinapInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codCustomerSnapshot = sourceOne.codSnapshot;
		resultInfo.codUser = sourceOne.codUser;

		return resultInfo;
	}
	
	
	
	private void checkArgument(CuslisInfo sourceOne, SchedinapInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(CuslisInfo sourceOne, SchedinapInfo sourceTwo) {
		return (sourceOne.codOwner    == sourceTwo.codOwner && 
				sourceOne.codCustomer == sourceTwo.codCustomer		);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
