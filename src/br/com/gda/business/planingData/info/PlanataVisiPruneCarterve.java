package br.com.gda.business.planingData.info;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.gda.business.cartReserve.info.CarterveInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoPrunerVisitor;

final class PlanataVisiPruneCarterve implements InfoPrunerVisitor<PlanataInfo, CarterveInfo> {
	
	@Override public PlanataInfo pruneRecord(PlanataInfo sourceOne, CarterveInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		if (hasTimeOverlap(sourceOne, sourceTwo))
			return null;
		
		return sourceOne;
	}
	
	
	
	private void checkArgument(PlanataInfo sourceOne, CarterveInfo sourceTwo) {
		if (shouldPrune(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.PRUNE_NOT_ALLOWED);
	}
	
	
	
	private boolean hasTimeOverlap(PlanataInfo planata, CarterveInfo recordInfo) {
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
	
	
	
	private boolean isDifferent(LocalDate planata, LocalDate caterve) {
		if (planata.equals(caterve))
			return false;
		
		return true;
	}
	
	
	
	private boolean isEqual(LocalTime planata, LocalTime caterve) {
		if (planata.equals(caterve))
			return true;
		
		return false;
	}	
	
	
	
	private boolean isEqualOrAfter(LocalTime planata, LocalTime caterve) {
		if (planata.equals(caterve))
			return true;
		
		if (planata.isAfter(caterve))
			return true;
		
		return false;
	}
	
	
	
	private boolean isEqualOrBefore(LocalTime planata, LocalTime caterve) {
		if (planata.equals(caterve))
			return true;
		
		if (planata.isBefore(caterve))
			return true;
		
		return false;
	}


	
	@Override public boolean shouldPrune(PlanataInfo sourceOne, CarterveInfo sourceTwo) {
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
