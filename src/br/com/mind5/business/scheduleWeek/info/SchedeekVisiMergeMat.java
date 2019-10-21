package br.com.mind5.business.scheduleWeek.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class SchedeekVisiMergeMat implements InfoMergerVisitor<SchedeekInfo, MatInfo> {

	@Override public SchedeekInfo writeRecord(MatInfo sourceOne, SchedeekInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		sourceTwo.mats.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	private void checkArgument(MatInfo sourceOne, SchedeekInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	


	
	@Override public boolean shouldWrite(MatInfo sourceOne, SchedeekInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
