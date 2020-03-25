package br.com.mind5.business.planingData.info;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.info.InfoPrunerSingleVisitor;

final class PlanataVisiPruneCarterve implements InfoPrunerSingleVisitor<PlanataInfo, CarterveInfo> {
	
	@Override public boolean pruneRecord(PlanataInfo baseInfo, CarterveInfo selectedInfo) {
		
		if (hasTimeOverlap(baseInfo, selectedInfo))
			return true;
		
		return false;
	}
	
	
	
	private boolean hasTimeOverlap(PlanataInfo baseInfo, CarterveInfo recordInfo) {
		if (isDifferent(baseInfo.date, recordInfo.date))
			return false;
		
		
		if (isEqual(baseInfo.beginTime, recordInfo.endTime))
			return false;
		
		
		if (isEqual(baseInfo.endTime, recordInfo.beginTime))
			return false;		
		
		
		if (isEqualOrAfter(baseInfo.beginTime, recordInfo.beginTime)	 &&
			isEqualOrBefore(baseInfo.beginTime, recordInfo.endTime)		)
			return true;
		
		
		if (isEqualOrAfter(baseInfo.endTime, recordInfo.beginTime)	 &&
			isEqualOrBefore(baseInfo.endTime, recordInfo.endTime)		)
			return true;
		
		
		if (isEqualOrBefore(baseInfo.beginTime, recordInfo.beginTime) &&
			isEqualOrAfter(baseInfo.endTime, recordInfo.endTime)			)
			return true;	
		
		
		return false;
	}
	
	
	
	private boolean isDifferent(LocalDate baseDate, LocalDate selectedDate) {
		if (baseDate.equals(selectedDate))
			return false;
		
		return true;
	}
	
	
	
	private boolean isEqual(LocalTime baseTime, LocalTime selectedTime) {
		if (baseTime.equals(selectedTime))
			return true;
		
		return false;
	}	
	
	
	
	private boolean isEqualOrAfter(LocalTime baseTime, LocalTime selectedTime) {
		if (baseTime.equals(selectedTime))
			return true;
		
		if (baseTime.isAfter(selectedTime))
			return true;
		
		return false;
	}
	
	
	
	private boolean isEqualOrBefore(LocalTime baseTime, LocalTime selectedTime) {
		if (baseTime.equals(selectedTime))
			return true;
		
		if (baseTime.isBefore(selectedTime))
			return true;
		
		return false;
	}



	@Override public boolean shouldPrune(PlanataInfo baseInfo, CarterveInfo selectedInfo) {
		if (baseInfo.codStore		<= 0	||
			baseInfo.codMat			<= 0	||
			baseInfo.codEmployee	<= 0	||
			baseInfo.date			== null	||
			baseInfo.beginTime		== null	||
			baseInfo.endTime		== null		)
			
			return false;
			
			
		return (baseInfo.codOwner 		== selectedInfo.codOwner		&&
				baseInfo.codStore 		== selectedInfo.codStore		&&
				baseInfo.codMat 		== selectedInfo.codMat			&&
				baseInfo.codEmployee 	== selectedInfo.codEmployee		);
	}
}
