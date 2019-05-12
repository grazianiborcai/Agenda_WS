package br.com.gda.business.planingData.info;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoPrunerVisitor;

final class PlanataVisiPruneEmplevate implements InfoPrunerVisitor<PlanataInfo, EmplevateInfo> {
	
	@Override public PlanataInfo pruneRecord(PlanataInfo sourceOne, EmplevateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		if (hasTimeOverlap(sourceOne, sourceTwo))
			return null;
		
		return sourceOne;
	}
	
	
	
	private void checkArgument(PlanataInfo sourceOne, EmplevateInfo sourceTwo) {
		if (shouldPrune(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.PRUNE_NOT_ALLOWED);
	}
	
	
	
	private boolean hasTimeOverlap(PlanataInfo planata, EmplevateInfo emplevate) {
		
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


	
	@Override public boolean shouldPrune(PlanataInfo sourceOne, EmplevateInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner	&&
				sourceOne.codEmployee 	== sourceTwo.codEmployee	);
	}

}
