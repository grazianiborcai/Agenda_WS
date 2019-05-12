package br.com.gda.business.planningTime_.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.age_.info.AgeInfo;
import br.com.gda.business.planningTime_.info.PlanInfo;
import br.com.gda.business.planningTime_.info.PlanPruner;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisiPlanPruneAge implements ActionVisitorEnforce<PlanInfo> {
	
	@Override public List<PlanInfo> executeTransformation(List<PlanInfo> recordInfos) {		
		return prune(recordInfos);
	}	
	
	
	
	private List<PlanInfo> prune(List<PlanInfo> recordInfos) {
		List<AgeInfo> ages = new ArrayList<>();
		AgeInfo ageDefault = new AgeInfo();
		ages.add(ageDefault);		
		
		return new PlanPruner().prune(recordInfos, ages);
	}
}
