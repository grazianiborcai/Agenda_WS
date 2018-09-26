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
		if (sourceOne.codOwner != sourceTwo.codOwner)
			throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		
		if (sourceOne.codStore != sourceTwo.codStore)
			throw new IllegalArgumentException("codStore" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
}
