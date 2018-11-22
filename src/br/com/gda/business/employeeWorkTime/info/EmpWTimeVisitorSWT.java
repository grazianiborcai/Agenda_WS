package br.com.gda.business.employeeWorkTime.info;

import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class EmpWTimeVisitorSWT implements InfoMergerVisitor<EmpWTimeInfo, StoreEmpInfo, StoreWTimeInfo> {

	@Override public EmpWTimeInfo writeRecord(StoreEmpInfo sourceOne, StoreWTimeInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpWTimeInfo resultInfo = EmpWTimeInfo.copyFrom(sourceTwo);
		resultInfo.codEmployee = sourceOne.codEmployee;		

		return resultInfo;
	}
	
	
	
	private void checkArgument(StoreEmpInfo sourceOne, StoreWTimeInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}



	@Override public boolean shouldWrite(StoreEmpInfo sourceOne, StoreWTimeInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codStore == sourceTwo.codStore);
	}
}
