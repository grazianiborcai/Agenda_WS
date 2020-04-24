package br.com.mind5.business.planningTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoPrunerListVisitor;
import br.com.mind5.masterData.dayParting.info.DaypartInfo;

final class PlanimeVisiPruneDaypart implements InfoPrunerListVisitor<PlanimeInfo, PlanimeInfo> {
	
	@Override public List<PlanimeInfo> pruneRecord(List<PlanimeInfo> baseInfos, List<PlanimeInfo> selectedInfos) {
		List<PlanimeInfo> results = new ArrayList<>();
		
		for (PlanimeInfo eachBase : baseInfos) {
			PlanimeInfo eachResult = pruneDaypart(eachBase);

			if (hasPlanata(eachResult.planatas))
				results.add(eachResult);
		}
		
		
		return results;
	}
	
	
	
	private PlanimeInfo pruneDaypart(PlanimeInfo recordInfo) {
		if (hasDaypart(recordInfo) == false)
			return recordInfo;
		
		
		if (hasPlanata(recordInfo.planatas) == false)
			return recordInfo;
		
		
		List<PlanataInfo> prunedPlanata = new ArrayList<>();
		
		for (PlanataInfo eachPlanata : recordInfo.planatas) {
			for (DaypartInfo eachDaypart : recordInfo.dayparts) {
				if (eachDaypart.codDaypart == eachPlanata.codDaypart) {
					prunedPlanata.add(eachPlanata);
					break;
				}
			}
		}
		
		recordInfo.planatas = prunedPlanata;
		return recordInfo;
	}
	
	
	
	private boolean hasDaypart(PlanimeInfo recordInfo) {
		boolean result = true;
		
		if (recordInfo.dayparts == null)
			result = false;
		
		if (recordInfo.dayparts.isEmpty())
			result = false;
		
		return result;
	}
	
	
	
	private boolean hasPlanata(List<PlanataInfo> recordInfos) {
		boolean result = true;
		
		if (recordInfos == null)
			result = false;
		
		if (recordInfos.isEmpty())
			result = false;
		
		return result;
	}
}
