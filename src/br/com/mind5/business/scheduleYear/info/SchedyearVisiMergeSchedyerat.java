package br.com.mind5.business.scheduleYear.info;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedyearVisiMergeSchedyerat implements InfoMergerVisitor_<SchedyearInfo, SchedyeratInfo> {

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
