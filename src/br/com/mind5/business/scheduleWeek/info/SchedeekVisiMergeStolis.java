package br.com.mind5.business.scheduleWeek.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedeekVisiMergeStolis implements InfoMergerVisitor_<SchedeekInfo, StolisInfo> {

	@Override public SchedeekInfo writeRecord(StolisInfo sourceOne, SchedeekInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		sourceTwo.stolises.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	private void checkArgument(StolisInfo sourceOne, SchedeekInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	


	
	@Override public boolean shouldWrite(StolisInfo sourceOne, SchedeekInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
