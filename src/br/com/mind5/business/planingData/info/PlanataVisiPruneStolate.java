package br.com.mind5.business.planingData.info;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoPrunerVisitor;

final class PlanataVisiPruneStolate implements InfoPrunerVisitor<PlanataInfo, StolateInfo> {
	
	@Override public PlanataInfo pruneRecord(PlanataInfo sourceOne, StolateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		if (hasTimeOverlap(sourceOne, sourceTwo))
			return null;
		
		return sourceOne;
	}
	
	
	
	private void checkArgument(PlanataInfo sourceOne, StolateInfo sourceTwo) {
		if (shouldPrune(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.PRUNE_NOT_ALLOWED);
	}
	
	
	
	private boolean hasTimeOverlap(PlanataInfo planata, StolateInfo emplevate) {
		
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


	
	@Override public boolean shouldPrune(PlanataInfo sourceOne, StolateInfo sourceTwo) {
		return (sourceOne.codOwner 	== sourceTwo.codOwner	&&
				sourceOne.codStore 	== sourceTwo.codStore		);
	}

}
