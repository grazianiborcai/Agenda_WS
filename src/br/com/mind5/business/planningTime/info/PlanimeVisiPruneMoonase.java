package br.com.mind5.business.planningTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoPrunerListVisitor;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;

final class PlanimeVisiPruneMoonase implements InfoPrunerListVisitor<PlanimeInfo, PlanimeInfo> {
	
	@Override public List<PlanimeInfo> pruneRecord(List<PlanimeInfo> baseInfos, List<PlanimeInfo> selectedInfos) {
		List<PlanimeInfo> results = new ArrayList<>();
		
		for (PlanimeInfo eachBase : baseInfos) {
			PlanimeInfo eachResult = pruneMoonase(eachBase);

			if (hasPlanata(eachResult.planatas))
				results.add(eachResult);
		}
		
		
		return results;
	}
	
	
	
	private PlanimeInfo pruneMoonase(PlanimeInfo recordInfo) {
		if (hasMoonase(recordInfo) == false)
			return recordInfo;
		
		
		if (hasPlanata(recordInfo.planatas) == false)
			return recordInfo;
		
		
		List<PlanataInfo> prunedPlanata = new ArrayList<>();
		
		for (PlanataInfo eachPlanata : recordInfo.planatas) {
			for (MoonaseInfo eachMoonase : recordInfo.moonases) {
				if (eachMoonase.codMoonPhase == eachPlanata.codMoonPhase) {
					prunedPlanata.add(eachPlanata);
					break;
				}
			}
		}
		
		recordInfo.planatas = prunedPlanata;
		return recordInfo;
	}
	
	
	
	private boolean hasMoonase(PlanimeInfo recordInfo) {
		boolean result = true;
		
		if (recordInfo.moonases == null)
			result = false;
		
		if (recordInfo.moonases.isEmpty())
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
