package br.com.gda.business.employeeWorkTime.info;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class EmpWTimeVisitorSWT implements InfoMergerVisitor<EmpWTimeInfo, EmposInfo, StoreWTimeInfo> {

	@Override public EmpWTimeInfo writeRecord(EmposInfo sourceOne, StoreWTimeInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpWTimeInfo resultInfo = EmpWTimeInfo.copyFrom(sourceTwo);
		resultInfo.codEmployee = sourceOne.codEmployee;		

		return resultInfo;
	}
	
	
	
	private void checkArgument(EmposInfo sourceOne, StoreWTimeInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}



	@Override public boolean shouldWrite(EmposInfo sourceOne, StoreWTimeInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codStore == sourceTwo.codStore);
	}
}
