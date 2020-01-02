package br.com.mind5.business.planingData.info;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.info.temp.InfoPrunerVisitorV2;

final class PlanataVisiPruneOrderve implements InfoPrunerVisitorV2<PlanataInfo, OrderveInfo> {
	
	@Override public boolean pruneRecord(PlanataInfo baseInfo, OrderveInfo selectedInfo) {
		
		if (hasTimeOverlap(baseInfo, selectedInfo))
			return true;
		
		return false;
	}
	
	
	
	private boolean hasTimeOverlap(PlanataInfo baseInfo, OrderveInfo selectedInfo) {
		if (isDifferent(baseInfo.date, selectedInfo.date))
			return false;
		
		
		if (isEqual(baseInfo.beginTime, selectedInfo.endTime))
			return false;
		
		
		if (isEqual(baseInfo.endTime, selectedInfo.beginTime))
			return false;		
		
		
		if (isEqualOrAfter(baseInfo.beginTime, selectedInfo.beginTime)	 &&
			isEqualOrBefore(baseInfo.beginTime, selectedInfo.endTime)		)
			return true;
		
		
		if (isEqualOrAfter(baseInfo.endTime, selectedInfo.beginTime)	 &&
			isEqualOrBefore(baseInfo.endTime, selectedInfo.endTime)			)
			return true;
		
		
		if (isEqualOrBefore(baseInfo.beginTime, selectedInfo.beginTime) &&
			isEqualOrAfter(baseInfo.endTime, selectedInfo.endTime)			)
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



	@Override public boolean shouldPrune(PlanataInfo baseInfo, OrderveInfo selectedInfo) {
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
