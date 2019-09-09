package br.com.gda.business.scheduleWeek.info;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class SchedeekVisiMergeCuslis implements InfoMergerVisitor<SchedeekInfo, CuslisInfo> {

	@Override public SchedeekInfo writeRecord(CuslisInfo sourceOne, SchedeekInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		sourceTwo.cuslises.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	private void checkArgument(CuslisInfo sourceOne, SchedeekInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	


	
	@Override public boolean shouldWrite(CuslisInfo sourceOne, SchedeekInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
