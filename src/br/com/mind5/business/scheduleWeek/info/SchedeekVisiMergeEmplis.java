package br.com.mind5.business.scheduleWeek.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

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
