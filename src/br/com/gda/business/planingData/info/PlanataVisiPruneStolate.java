package br.com.gda.business.planingData.info;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoPrunerVisitor;

final class PlanataVisiPruneStolevate implements InfoPrunerVisitor<PlanataInfo, StolevateInfo> {
	
	@Override public PlanataInfo pruneRecord(PlanataInfo sourceOne, StolevateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		if (hasTimeOverlap(sourceOne, sourceTwo))
			return null;
		
		return sourceOne;
	}
	
	
	
	private void checkArgument(PlanataInfo sourceOne, StolevateInfo sourceTwo) {
		if (shouldPrune(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.PRUNE_NOT_ALLOWED);
	}
	
	
	
	private boolean hasTimeOverlap(PlanataInfo planata, StolevateInfo emplevate) {
		
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


	
	@Override public boolean shouldPrune(PlanataInfo sourceOne, StolevateInfo sourceTwo) {
		return (sourceOne.codOwner 	== sourceTwo.codOwner	&&
				sourceOne.codStore 	== sourceTwo.codStore		);
	}

}
