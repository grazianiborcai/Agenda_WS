package br.com.gda.business.scheduleYear.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class SchedyearVisiMergeStolis implements InfoMergerVisitor<SchedyearInfo, StolisInfo> {

	@Override public SchedyearInfo writeRecord(StolisInfo sourceOne, SchedyearInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		sourceTwo.stolises.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	private void checkArgument(StolisInfo sourceOne, SchedyearInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	


	
	@Override public boolean shouldWrite(StolisInfo sourceOne, SchedyearInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
