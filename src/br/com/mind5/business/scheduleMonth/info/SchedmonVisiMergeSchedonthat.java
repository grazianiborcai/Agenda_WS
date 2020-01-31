package br.com.mind5.business.scheduleMonth.info;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedmonVisiMergeSchedonthat implements InfoMergerVisitor_<SchedmonInfo, SchedonthatInfo> {

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
