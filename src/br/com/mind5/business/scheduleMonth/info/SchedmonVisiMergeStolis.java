package br.com.mind5.business.scheduleMonth.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedmonVisiMergeStolis implements InfoMergerVisitor_<SchedmonInfo, StolisInfo> {

	@Override public SchedmonInfo writeRecord(StolisInfo sourceOne, SchedmonInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		sourceTwo.stolises.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	private void checkArgument(StolisInfo sourceOne, SchedmonInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	


	
	@Override public boolean shouldWrite(StolisInfo sourceOne, SchedmonInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
