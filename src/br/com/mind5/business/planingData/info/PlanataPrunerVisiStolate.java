package br.com.mind5.business.planingData.info;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.info.InfoPrunerSingleVisitor;

final class PlanataPrunerVisiStolate implements InfoPrunerSingleVisitor<PlanataInfo, StolateInfo> {
	
	@Override public boolean pruneRecord(PlanataInfo baseInfo, StolateInfo selectedInfo) {
		
		if (hasTimeOverlap(baseInfo, selectedInfo))
			return true;
		
		return false;
	}
	
	
	
	private boolean hasTimeOverlap(PlanataInfo baseInfo, StolateInfo selectedInfo) {
		
		if ((baseInfo.date.isAfter(selectedInfo.dateValidFrom)      || baseInfo.date.isEqual(selectedInfo.dateValidFrom)) 	  &&
			(baseInfo.date.isBefore(selectedInfo.dateValidTo)       || baseInfo.date.isEqual(selectedInfo.dateValidTo)) 	  &&
			(baseInfo.beginTime.isAfter(selectedInfo.timeValidFrom) || baseInfo.beginTime.equals(selectedInfo.timeValidFrom)) &&
			(baseInfo.beginTime.isBefore(selectedInfo.timeValidTo)  || baseInfo.beginTime.equals(selectedInfo.timeValidTo)))
			return true;		
		
		
		if ((baseInfo.date.isAfter(selectedInfo.dateValidFrom)    || baseInfo.date.isEqual(selectedInfo.dateValidFrom))   &&
			(baseInfo.date.isBefore(selectedInfo.dateValidTo)     || baseInfo.date.isEqual(selectedInfo.dateValidTo)) 	  &&
			(baseInfo.endTime.isAfter(selectedInfo.timeValidFrom) || baseInfo.endTime.equals(selectedInfo.timeValidFrom)) &&
			(baseInfo.endTime.isBefore(selectedInfo.timeValidTo)  || baseInfo.endTime.equals(selectedInfo.timeValidTo)))
			return true;	
		
		
		return false;
	}



	@Override public boolean shouldPrune(PlanataInfo baseInfo, StolateInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore	);
	}
}
