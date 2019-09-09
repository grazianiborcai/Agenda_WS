package br.com.gda.business.scheduleWeek.info;

import br.com.gda.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class SchedeekVisiMergeSchedeekdat implements InfoMergerVisitor<SchedeekInfo, SchedeekdatInfo> {

	@Override public SchedeekInfo writeRecord(SchedeekdatInfo sourceOne, SchedeekInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		sourceTwo.schedeekdats.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	private void checkArgument(SchedeekdatInfo sourceOne, SchedeekInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	


	
	@Override public boolean shouldWrite(SchedeekdatInfo sourceOne, SchedeekInfo sourceTwo) {		
		return (sourceOne.codOwner 	== sourceTwo.codOwner && 
				sourceOne.year     	== sourceTwo.year	  &&
				sourceOne.month    	== sourceTwo.month	  &&
				sourceOne.weekMonth == sourceTwo.weekMonth);
	}
}
