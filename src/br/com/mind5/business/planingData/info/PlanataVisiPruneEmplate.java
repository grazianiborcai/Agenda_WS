package br.com.mind5.business.planingData.info;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.info.InfoPrunerVisitor;

final class PlanataVisiPruneEmplate implements InfoPrunerVisitor<PlanataInfo, EmplateInfo> {
	
	@Override public boolean pruneRecord(PlanataInfo baseInfo, EmplateInfo selectedInfo) {
		
		if (hasTimeOverlap(baseInfo, selectedInfo))
			return true;
		
		return false;
	}
	
	
	
	private boolean hasTimeOverlap(PlanataInfo baseInfo, EmplateInfo selectedInfo) {
		
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



	@Override public boolean shouldPrune(PlanataInfo baseInfo, EmplateInfo selectedInfo) {
		return (baseInfo.codOwner 		== selectedInfo.codOwner	&&
				baseInfo.codStore 		== selectedInfo.codStore	&&
				baseInfo.codEmployee 	== selectedInfo.codEmployee	);
	}
}
