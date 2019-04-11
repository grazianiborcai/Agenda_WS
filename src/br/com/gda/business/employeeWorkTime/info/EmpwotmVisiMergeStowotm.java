package br.com.gda.business.employeeWorkTime.info;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class EmpwotmVisiMergeStowotm implements InfoMergerVisitor<EmpwotmInfo, EmposInfo, StowotmInfo> {

	@Override public EmpwotmInfo writeRecord(EmposInfo sourceOne, StowotmInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpwotmInfo resultInfo = EmpwotmInfo.copyFrom(sourceTwo);
		resultInfo.codEmployee = sourceOne.codEmployee;		

		return resultInfo;
	}
	
	
	
	private void checkArgument(EmposInfo sourceOne, StowotmInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}



	@Override public boolean shouldWrite(EmposInfo sourceOne, StowotmInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codStore == sourceTwo.codStore);
	}
}
