package br.com.mind5.business.scheduleMonth.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class SchedmonVisiMergeMatlis implements InfoMergerVisitor<SchedmonInfo, MatlisInfo> {

	@Override public SchedmonInfo writeRecord(MatlisInfo sourceOne, SchedmonInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		sourceTwo.matlises.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	private void checkArgument(MatlisInfo sourceOne, SchedmonInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	


	
	@Override public boolean shouldWrite(MatlisInfo sourceOne, SchedmonInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
