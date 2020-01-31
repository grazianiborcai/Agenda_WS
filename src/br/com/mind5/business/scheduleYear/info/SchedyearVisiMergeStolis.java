package br.com.mind5.business.scheduleYear.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedyearVisiMergeStolis implements InfoMergerVisitor_<SchedyearInfo, StolisInfo> {

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
