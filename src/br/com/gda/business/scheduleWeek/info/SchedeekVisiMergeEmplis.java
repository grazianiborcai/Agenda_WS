package br.com.gda.business.scheduleWeek.info;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class SchedeekVisiMergeEmplis implements InfoMergerVisitor<SchedeekInfo, EmplisInfo> {

	@Override public SchedeekInfo writeRecord(EmplisInfo sourceOne, SchedeekInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		sourceTwo.emplises.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	private void checkArgument(EmplisInfo sourceOne, SchedeekInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	


	
	@Override public boolean shouldWrite(EmplisInfo sourceOne, SchedeekInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
