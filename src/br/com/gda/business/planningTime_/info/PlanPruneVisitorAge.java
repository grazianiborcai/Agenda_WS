package br.com.gda.business.planningTime_.info;

import br.com.gda.business.age.info.AgeInfo;
import br.com.gda.info.InfoPrunerVisitor;

final class PlanPruneVisitorAge implements InfoPrunerVisitor<PlanInfo, AgeInfo> {
	
	@Override public PlanInfo pruneRecord(PlanInfo sourceOne, AgeInfo sourceTwo) {		
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceOne.stores);
		resultInfo.employees.addAll(sourceOne.employees);
		resultInfo.materials.addAll(sourceOne.materials);
		resultInfo.weekdays.addAll(sourceOne.weekdays);
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (shouldPrune(eachData, sourceTwo) == false) {
				resultInfo.datas.add(eachData);
			}
		}		
		
		if (resultInfo.datas.isEmpty())
			return null;
		
		return resultInfo;
	}
	
	
	
	private boolean shouldPrune(PlanDataInfo planData, AgeInfo ageChecker) {
		return ageChecker.isAged(planData);
	}
}
