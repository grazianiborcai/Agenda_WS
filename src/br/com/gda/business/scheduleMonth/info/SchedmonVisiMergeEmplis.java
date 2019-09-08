package br.com.gda.business.scheduleMonth.info;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class SchedmonVisiMergeEmplis implements InfoMergerVisitor<SchedmonInfo, EmplisInfo> {

	@Override public SchedmonInfo writeRecord(EmplisInfo sourceOne, SchedmonInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		sourceTwo.emplises.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	private void checkArgument(EmplisInfo sourceOne, SchedmonInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	


	
	@Override public boolean shouldWrite(EmplisInfo sourceOne, SchedmonInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
