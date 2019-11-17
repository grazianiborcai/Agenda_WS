package br.com.mind5.business.planingData.info;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoPrunerVisitor;

final class PlanataVisiPruneEmplate implements InfoPrunerVisitor<PlanataInfo, EmplateInfo> {
	
	@Override public PlanataInfo pruneRecord(PlanataInfo sourceOne, EmplateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		if (hasTimeOverlap(sourceOne, sourceTwo))
			return null;
		
		return sourceOne;
	}
	
	
	
	private void checkArgument(PlanataInfo sourceOne, EmplateInfo sourceTwo) {
		if (shouldPrune(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.PRUNE_NOT_ALLOWED);
	}
	
	
	
	private boolean hasTimeOverlap(PlanataInfo planata, EmplateInfo emplevate) {
		
		if ((planata.date.isAfter(emplevate.dateValidFrom)      || planata.date.isEqual(emplevate.dateValidFrom)) 	  &&
			(planata.date.isBefore(emplevate.dateValidTo)       || planata.date.isEqual(emplevate.dateValidTo)) 	  &&
			(planata.beginTime.isAfter(emplevate.timeValidFrom) || planata.beginTime.equals(emplevate.timeValidFrom)) &&
			(planata.beginTime.isBefore(emplevate.timeValidTo)  || planata.beginTime.equals(emplevate.timeValidTo)))
			return true;		
		
		
		if ((planata.date.isAfter(emplevate.dateValidFrom)    || planata.date.isEqual(emplevate.dateValidFrom))   &&
			(planata.date.isBefore(emplevate.dateValidTo)     || planata.date.isEqual(emplevate.dateValidTo)) 	  &&
			(planata.endTime.isAfter(emplevate.timeValidFrom) || planata.endTime.equals(emplevate.timeValidFrom)) &&
			(planata.endTime.isBefore(emplevate.timeValidTo)  || planata.endTime.equals(emplevate.timeValidTo)))
			return true;	
		
		return false;
	}


	
	@Override public boolean shouldPrune(PlanataInfo sourceOne, EmplateInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner	&&
				sourceOne.codStore 		== sourceTwo.codStore	&&
				sourceOne.codEmployee 	== sourceTwo.codEmployee	);
	}

}
