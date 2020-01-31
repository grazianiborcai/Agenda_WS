package br.com.mind5.business.scheduleMonth.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedmonVisiMergeEmplis implements InfoMergerVisitor_<SchedmonInfo, EmplisInfo> {

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
