package br.com.gda.business.scheduleMonth.info;

import br.com.gda.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class SchedmonVisiMergeSchedonthat implements InfoMergerVisitor<SchedmonInfo, SchedonthatInfo> {

	@Override public SchedmonInfo writeRecord(SchedonthatInfo sourceOne, SchedmonInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		sourceTwo.schedonthats.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	private void checkArgument(SchedonthatInfo sourceOne, SchedmonInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	


	
	@Override public boolean shouldWrite(SchedonthatInfo sourceOne, SchedmonInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner && 
				sourceOne.year     == sourceTwo.year	 &&
				sourceOne.month    == sourceTwo.month);
	}
}
