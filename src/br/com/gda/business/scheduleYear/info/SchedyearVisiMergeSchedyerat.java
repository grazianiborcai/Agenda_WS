package br.com.gda.business.scheduleYear.info;

import br.com.gda.business.scheduleYearData.info.SchedyeratInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class SchedyearVisiMergeSchedyerat implements InfoMergerVisitor<SchedyearInfo, SchedyeratInfo> {

	@Override public SchedyearInfo writeRecord(SchedyeratInfo sourceOne, SchedyearInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		sourceTwo.schedyerats.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	private void checkArgument(SchedyeratInfo sourceOne, SchedyearInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	


	
	@Override public boolean shouldWrite(SchedyeratInfo sourceOne, SchedyearInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner && 
				sourceOne.year     == sourceTwo.year);
	}
}
