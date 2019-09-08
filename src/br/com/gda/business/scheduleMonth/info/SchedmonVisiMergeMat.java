package br.com.gda.business.scheduleMonth.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class SchedmonVisiMergeMat implements InfoMergerVisitor<SchedmonInfo, MatInfo> {

	@Override public SchedmonInfo writeRecord(MatInfo sourceOne, SchedmonInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		sourceTwo.mats.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	private void checkArgument(MatInfo sourceOne, SchedmonInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	


	
	@Override public boolean shouldWrite(MatInfo sourceOne, SchedmonInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
