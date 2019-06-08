package br.com.gda.business.planingData.info;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.gda.business.orderReserve.info.OrderveInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoPrunerVisitor;

final class PlanataVisiPruneOrderve implements InfoPrunerVisitor<PlanataInfo, OrderveInfo> {
	
	@Override public PlanataInfo pruneRecord(PlanataInfo sourceOne, OrderveInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		if (hasTimeOverlap(sourceOne, sourceTwo))
			return null;
		
		return sourceOne;
	}
	
	
	
	private void checkArgument(PlanataInfo sourceOne, OrderveInfo sourceTwo) {
		if (shouldPrune(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.PRUNE_NOT_ALLOWED);
	}
	
	
	
	private boolean hasTimeOverlap(PlanataInfo planata, OrderveInfo recordInfo) {
		if (isDifferent(planata.date, recordInfo.date))
			return false;
		
		
		if (isEqual(planata.beginTime, recordInfo.endTime))
			return false;
		
		
		if (isEqual(planata.endTime, recordInfo.beginTime))
			return false;		
		
		
		if (isEqualOrAfter(planata.beginTime, recordInfo.beginTime)	 &&
			isEqualOrBefore(planata.beginTime, recordInfo.endTime)		)
			return true;
		
		
		if (isEqualOrAfter(planata.endTime, recordInfo.beginTime)	 &&
			isEqualOrBefore(planata.endTime, recordInfo.endTime)		)
			return true;
		
		
		if (isEqualOrBefore(planata.beginTime, recordInfo.beginTime) &&
			isEqualOrAfter(planata.endTime, recordInfo.endTime)			)
			return true;	
		
		
		return false;
	}
	
	
	
	private boolean isDifferent(LocalDate planata, LocalDate orderve) {
		if (planata.equals(orderve))
			return false;
		
		return true;
	}
	
	
	private boolean isEqual(LocalTime planata, LocalTime orderve) {
		if (planata.equals(orderve))
			return true;
		
		return false;
	}		
	
	
	
	private boolean isEqualOrAfter(LocalTime planata, LocalTime orderve) {
		if (planata.equals(orderve))
			return true;
		
		if (planata.isAfter(orderve))
			return true;
		
		return false;
	}
	
	
	
	private boolean isEqualOrBefore(LocalTime planata, LocalTime orderve) {
		if (planata.equals(orderve))
			return true;
		
		if (planata.isBefore(orderve))
			return true;
		
		return false;
	}


	
	@Override public boolean shouldPrune(PlanataInfo sourceOne, OrderveInfo sourceTwo) {
		if (sourceOne.codStore		<= 0	||
			sourceOne.codMat		<= 0	||
			sourceOne.codEmployee	<= 0	||
			sourceOne.date			== null	||
			sourceOne.beginTime		== null	||
			sourceOne.endTime		== null		)
			
			return false;
		
		
		return (sourceOne.codOwner 		== sourceTwo.codOwner		&&
				sourceOne.codStore 		== sourceTwo.codStore		&&
				sourceOne.codMat 		== sourceTwo.codMat			&&
				sourceOne.codEmployee 	== sourceTwo.codEmployee		);
	}
}
