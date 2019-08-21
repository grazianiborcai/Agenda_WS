package br.com.gda.business.scheduleLine.info;

import br.com.gda.business.orderList.info.OrdistInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class SchedineVisiMergeOrdist implements InfoMergerVisitor<SchedineInfo, OrdistInfo> {

	@Override public SchedineInfo writeRecord(OrdistInfo sourceOne, SchedineInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(OrdistInfo sourceOne, SchedineInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private SchedineInfo merge(OrdistInfo sourceOne, SchedineInfo sourceTwo) {
		sourceTwo.codOrderStatus = sourceOne.codOrderStatus;		
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(OrdistInfo sourceOne, SchedineInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner &&
				sourceOne.codOrder == sourceTwo.codOrder	);
	}
}
